package com.tcode.persistence.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Sergey on 11/15/2015.
 */
@Document
public class Technology extends ArticleModel {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
