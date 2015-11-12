package com.tcode.common;

import com.mongodb.BasicDBObject;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sroshchupkin on 11/11/15.
 */
@Component
public class GroupUtil {

    public Set<String> toSet(Iterable<BasicDBObject> iterable, String fieldName) {
        Set<String> set = new HashSet<>();

        for (BasicDBObject group : iterable) {
            set.add((String) group.get(fieldName));
        }
        return set;
    }
}

