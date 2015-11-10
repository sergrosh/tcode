package com.tcode.persistence.model;

import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created by Sergey Roshchupkin on 10/11/15.
 */
public abstract class ArticleModel extends PublishModel {

    @Indexed
    private String category;
    private String link;
    private String about;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
