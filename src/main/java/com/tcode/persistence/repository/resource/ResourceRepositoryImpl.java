package com.tcode.persistence.repository.resource;

import com.mongodb.BasicDBObject;
import com.tcode.common.GroupUtil;
import com.tcode.persistence.model.Resource;
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
 * Created by Sergey on 11/15/2015.
 */
public class ResourceRepositoryImpl implements ResourceRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private GroupUtil groupUtil;

    @Override
    public boolean isExistsByTitle(String title) {
        Query query = Query.query(Criteria.where("title").is(title));
        long count = mongoTemplate.count(query, Resource.class);
        return count > 0;
    }

    @Override
    public Set<String> findCategories(boolean isPublished) {

        GroupBy groupBy = GroupBy.key("category").initialDocument("{}").reduceFunction("function(curr,result){}");

        GroupByResults<BasicDBObject> group = mongoTemplate.group(
                Criteria.where("published").is(isPublished), mongoTemplate.getCollectionName(Resource.class), groupBy, BasicDBObject.class);

        return groupUtil.toSet(group, "category");
    }

    @Override
    public Set<String> findAllCategories() {

        GroupBy groupBy = GroupBy.key("category").initialDocument("{}").reduceFunction("function(curr,result){}");

        GroupByResults<BasicDBObject> group = mongoTemplate.group(mongoTemplate.getCollectionName(Resource.class), groupBy, BasicDBObject.class);

        return groupUtil.toSet(group, "category");
    }

    @Override
    public Map<String, List<Resource>> findGroupByCategories(boolean isPublished) {
        HashMap<String, List<Resource>> map = new HashMap<>();

        for (String category : findCategories(isPublished)) {
            map.put(category, mongoTemplate.find(Query.query(Criteria.where("category").is(category).and("published").is(isPublished)), Resource.class));
        }

        return map;
    }
}
