package com.tcode.persistence.model;

/**
 * Created by Sergey Roshchupkin on 10/11/15.
 */
public enum SiteTheme {
    WHITE("White", "bootstrap.css"), BLACK("Black", "bootstrap.css");
    private String name;
    private String css;

    SiteTheme(String name, String css) {
        this.name = name;
        this.css = css;
    }

    public String getName() {
        return name;
    }

    public String getCss() {
        return css;
    }
}