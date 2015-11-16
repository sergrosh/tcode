package com.tcode.service;

import com.mongodb.BasicDBList;
import com.tcode.persistence.model.Note;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sroshchupkin on 16/11/15.
 */

@Service
public class SearchService {
    @Autowired
    private MongoTemplate template;

    public Page<Note> search(String q, Pageable pageable) {
        if (StringUtils.isEmpty(q)) {
            return new PageImpl<>(Collections.<Note>emptyList(), pageable, 0);
        }

        PageImpl<Note> page = new PageImpl<>(template.find(new SearchQueryBuilder(q, pageable).build(), Note.class),
                pageable,
                template.count(new SearchQueryBuilder(q, pageable).build(), Note.class)
        );

        return page;
    }

    private static class SearchQueryBuilder {
        private static final String TAG_OPEN = "[";
        private static final String TAG_CLOSE = "]";
        private static final String USERNAME_CLOSE = "@";
        private static final String USERNAME_OPEN = "@";
        private String temp;
        private Query query = new Query();
        private Pageable pageable;

        private SearchQueryBuilder(String question, Pageable pageable) {
            this.temp = question;
            this.pageable = pageable;
        }

        public Query build() {
            Set<String> tags = parseAndCleanTags();
            if (tags != null && !tags.isEmpty()) {
                query.addCriteria(Criteria.where("tags").in(tags));
            }

            Set<String> usernames = parseAndCleanUsernames();
            if (usernames != null && !usernames.isEmpty()) {
                query.addCriteria(Criteria.where("username").in(usernames));
            }

            String regex = ".*" + temp + ".*";
            query.addCriteria(new Criteria("$or").is(createCriteriaList(
                            Criteria.where("title").regex(regex),
                            Criteria.where("description").regex(regex),
                            Criteria.where("snippets.title").regex(regex),
                            Criteria.where("snippets.code").regex(regex),
                            Criteria.where("snippets.description").regex(regex))
            ));
            query.with(pageable);

            return query;
        }

        private BasicDBList createCriteriaList(Criteria... criteria) {
            BasicDBList bsonList = new BasicDBList();
            for (Criteria c : criteria) {
                bsonList.add(c.getCriteriaObject());
            }
            return bsonList;
        }

        private Set<String> parseAndCleanUsernames() {
            String[] strings = StringUtils.substringsBetween(temp, USERNAME_OPEN, USERNAME_CLOSE);
            if (strings == null) {
                return null;
            } else {
                HashSet<String> set = new HashSet<>(Arrays.asList(strings));
                for (String s : set) {
                    temp = temp.replace(USERNAME_OPEN + s + USERNAME_CLOSE, "");
                }
                return set;
            }
        }

        private Set<String> parseAndCleanTags() {
            String[] strings = StringUtils.substringsBetween(temp, TAG_OPEN, TAG_CLOSE);
            if (strings == null) {
                return null;
            } else {
                HashSet<String> set = new HashSet<>(Arrays.asList(strings));
                for (String s : set) {
                    temp = temp.replace(TAG_OPEN + s + TAG_CLOSE, "");
                }
                return set;
            }
        }
    }
}

