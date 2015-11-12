package com.tcode.persistence.repository.tool;

import com.mongodb.BasicDBObject;
import com.tcode.common.GroupUtil;
import com.tcode.persistence.model.SpringUser;
import com.tcode.persistence.model.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by sroshchupkin on 11/11/15.
 */
public class ToolRepositoryImpl implements ToolRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private GroupUtil groupUtil;

    @Override
    public boolean isExistsByName(String name) {
        Query query = Query.query(Criteria.where("name").is(name));
        long count = mongoTemplate.count(query, SpringUser.class);
        return count > 0;
    }

    @Override
    public Set<String> findCategories(boolean isPublished) {

        GroupBy groupBy = GroupBy.key("category").initialDocument("{}").reduceFunction("function(curr,result){}");

        GroupByResults<BasicDBObject> group = mongoTemplate.group(
                Criteria.where("published").is(isPublished), mongoTemplate.getCollectionName(Tool.class), groupBy, BasicDBObject.class);
        return groupUtil.toSet(group, "category");
    }

    @Override
    public Set<String> findAllCategories() {

        GroupBy groupBy = GroupBy.key("category").initialDocument("{}").reduceFunction("function(curr,result){}");

        GroupByResults<BasicDBObject> group = mongoTemplate.group(mongoTemplate.getCollectionName(Tool.class), groupBy, BasicDBObject.class);

        return groupUtil.toSet(group, "category");
    }

    @Override
    public Map<String, List<Tool>> findGroupByCategories(boolean isPublished) {
        HashMap<String, List<Tool>> map = new HashMap<>();

        for (String category : findCategories(isPublished)) {
            map.put(category, mongoTemplate.find(Query.query(Criteria.where("category").is(category).and("published").is(isPublished)), Tool.class));
        }

        return map;
    }
}
