package com.tcode.persistence.model;

/**
 * Created by Sergey Roshchupkin on 10/11/15.
 */
public class Snippet {

    private String title;
    private String code;
    private String description;
    private String xtype;

    public String getXtype() {
        return xtype;
    }

    public void setXtype(String xtype) {
        this.xtype = xtype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
