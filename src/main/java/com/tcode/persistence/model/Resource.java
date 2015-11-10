package com.tcode.persistence.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Sergey Roshchupkin on 10/11/15.
 */
@Document
public class Resource extends ArticleModel {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
