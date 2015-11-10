package com.tcode.persistence.model;

/**
 * Created by sroshchupkin on 10/11/15.
 */
public enum SyntaxHighlighterTheme {
    DEFAULT("Default", "shThemeDefault.css"),
    DJANGO("Django", "shThemeDjango.css"),
    ECLIPSE("Eclipse", "shThemeEclipse.css"),
    EMACS("Emacs", "shThemeEmacs.css"),
    FADE_TO_GREY("Fade To Grey", "shThemeFadeToGrey.css"),
    MIDNIGHT("Midnight", "shThemeMidnight.css"),
    RDARK("RDark", "shThemeRDark.css");

    private String name;
    private String css;

    SyntaxHighlighterTheme(String name, String css) {
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
