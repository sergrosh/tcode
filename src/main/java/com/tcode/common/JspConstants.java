package com.tcode.common;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sergey Roshchupkin on 11/8/2015.
 */
public class JspConstants extends HashMap<String, String> {

    public JspConstants(Class clazz, String contextPath) throws IllegalAccessException {
        if (clazz.isInterface()) {
            List<Field> fields = new ArrayList<>();
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

            for (Field field : fields) {
                put(field.getName(), contextPath + field.get(null));
            }
        } else {
            throw new IllegalArgumentException("Class should be an interface!");
        }
    }

    public JspConstants(Class clazz) throws IllegalAccessException {
        if (clazz.isInterface()) {
            List<Field> fields = new ArrayList<>();
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

            for (Field field : fields) {
                put(field.getName(), (String) field.get(null));
            }
        } else {
            throw new IllegalArgumentException("Class should be an interface!");
        }
    }

    @Override
    public String get(Object key) {
        String result = super.get(key);
        if (StringUtils.isEmpty(result)) {
            throw new IllegalArgumentException("Check key as '" + key + "'! The key is wrong, no such constant!");
        }
        return result;
    }
}

