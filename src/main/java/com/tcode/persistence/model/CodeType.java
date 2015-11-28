package com.tcode.persistence.model;

/**
 * Created by Sergey on 11/25/2015.
 */
public enum CodeType {
    JAVA("Java", "text/x-java", "clike", "java"),
    C("C", "text/x-csrc", "clike", "c"),
    C_PP("C++", "text/x-c++src", "clike", "cpp"),
    C_SHARP("C#", "text/x-csharp", "clike", "csharp"),
    //    JSP("JSP", "application/x-jsp", "htmlembedded", "js"),
    HTML("HTML", "text/html", "htmlmixed", "html"),
    JAVASCRIPT("JavaScript", "text/javascript", "javascript", "javascript"),
    CSS("CSS", "text/css", "css", "css"),
    GROOVY("Groovy", "text/x-groovy", "groovy", "groovy"),
    PROPERTIES("Properties", "text/x-properties", "properties", "text"),
    SHELL("Shell/Bash", "text/x-sh", "shell", "shell"),
    PASCAL("Delphi/Pascal", "text/x-pascal", "pascal", "pascal"),
    DIFF("Diff", "text/x-diff", "diff", "diff"),
    ERLANG("erlang", "text/x-erlang", "erlang", "erlang"),
    PERL("Perl", "text/x-perl", "perl", "perl"),
    PHP("PHP", "application/x-httpd-php", "php", "php"),
    POWERSHELL("PowerShell", "text/x-psh", "shell", "powershell"),
    PYTHON("Python", "text/x-python", "python", "python"),
    RUBY("Ruby", "text/x-ruby", "ruby", "ruby"),
    SCALA("Scala", "text/x-scala", "clike", "scala"),
    SQL("SQL", "text/x-sql", "sql", "sql"),
    VB("Visual Basic", " text/x-vb", "vb", "vbnet"),
    XML("XML", "application/xml", "xml", "xml");

    private String name;
    private String xtype;
    private String cmFileName;
    private String shBrush;

    CodeType(String name, String xtype, String cmFileName, String shBrush) {
        this.name = name;
        this.xtype = xtype;
        this.cmFileName = cmFileName;
        this.shBrush = shBrush;
    }

    public static CodeType getByXtype(String xtype) {
        for (CodeType codeType : CodeType.values()) {
            if (codeType.getXtype().equals(xtype)) {
                return codeType;
            }
        }
        throw new IllegalArgumentException("No such code type! with xtype: " + xtype);
    }

    public String getName() {
        return name;
    }

    public String getXtype() {
        return xtype;
    }

    public String getCmFileName() {
        return cmFileName;
    }

    public String getShBrush() {
        return shBrush;
    }
}
