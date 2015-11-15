package com.tcode.common.strategy.impl;

import com.tcode.common.strategy.Action;
import com.tcode.persistence.model.SpringUser;
import com.tcode.persistence.model.SyntaxHighlighterTheme;

/**
 * Created by Sergey on 11/13/2015.
 */
public class ShThemeAction implements Action<SpringUser, String> {
    @Override
    public SpringUser execute(SpringUser loggedUser, String value) {
        SyntaxHighlighterTheme syntaxHighlighterTheme = SyntaxHighlighterTheme.valueOf(value);
        loggedUser.getOptions().setSyntaxHighlighterTheme(syntaxHighlighterTheme);
        return loggedUser;
    }
}
