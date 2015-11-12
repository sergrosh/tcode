package com.tcode.persistence.model;

import java.io.Serializable;

/**
 * Created by Sergey Roshchupkin on 10/11/15.
 */
public class UserOptions implements Serializable {

    private CodeMirrorTheme codeMirrorTheme = CodeMirrorTheme.AMBIANCE;
    private SiteTheme siteTheme = SiteTheme.WHITE;
    private SyntaxHighlighterTheme syntaxHighlighterTheme = SyntaxHighlighterTheme.DEFAULT;

    public SyntaxHighlighterTheme getSyntaxHighlighterTheme() {
        return syntaxHighlighterTheme;
    }

    public void setSyntaxHighlighterTheme(SyntaxHighlighterTheme syntaxHighlighterTheme) {
        this.syntaxHighlighterTheme = syntaxHighlighterTheme;
    }

    public SiteTheme getSiteTheme() {
        return siteTheme;
    }

    public void setSiteTheme(SiteTheme siteTheme) {
        this.siteTheme = siteTheme;
    }

    public CodeMirrorTheme getCodeMirrorTheme() {
        return codeMirrorTheme;
    }

    public void setCodeMirrorTheme(CodeMirrorTheme codeMirrorTheme) {
        this.codeMirrorTheme = codeMirrorTheme;
    }
}

