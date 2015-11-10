package com.tcode.persistence.model;

/**
 * Created by Sergey Roshchupkin on 10/11/15.
 */
public abstract class PublishModel extends BaseModel {

    private Boolean published = Boolean.FALSE;

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }
}
