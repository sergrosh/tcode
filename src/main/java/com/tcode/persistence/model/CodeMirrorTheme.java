package com.tcode.persistence.model;

/**
 * Created by Sergey Roshchupkin on 10/11/15.
 */
public enum CodeMirrorTheme {
    AMBIANCE("Ambiance", "ambiance.css", "ambiance"),
    AMBIANCE_MOBILE("Ambiance-mobile", "ambiance-mobile.css", "ambiance-mobile"),
    BLACKBOARD("Blackboard", "blackboard.css", "blackboard"),
    COBALT("Cobalt", "cobalt.css", "cobalt"),
    ECLIPSE("Eclipse", "eclipse.css", "eclipse"),
    ELEGANT("Elegant", "elegant.css", "elegant"),
    ERLANG_DARK("Erlang", "erlang-dark.css", "erlang-dark"),
    LESSER_DARK("Lesser-dark", "lesser-dark.css", "lesser-dark"),
    MIDNIGHT("Midnight", "midnight.css", "midnight"),
    MONOKAI("Monokai", "monokai.css", "monokai"),
    NEAT("Neat", "neat.css", "neat"),
    NIGHT("Night", "night.css", "night"),
    RUBYBLUE("Ruby blue", "rubyblue.css", "rubyblue"),
    SOLARIZED("Solarized", "solarized.css", "solarized"),
    TWILIGHT("Twilight", "twilight.css", "twilight"),
    VIBRANT_INK("Vibrant-ink", "vibrant-ink.css", "vibrant-ink"),
    XQ_DARK("xq-dark", "xq-dark.css", "xq-dark"),
    XQ_LIGHT("xq-light", "xq-light.css", "xq-light");

    private String name;
    private String css;
    private String value;

    CodeMirrorTheme(String name, String css, String value) {
        this.name = name;
        this.css = css;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getCss() {
        return css;
    }
}

