package com.tcode.persistence.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by sroshchupkin on 11/11/15.
 */
@Document
public class Tool extends ArticleModel {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
