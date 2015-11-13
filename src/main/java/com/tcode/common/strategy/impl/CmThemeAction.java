package com.tcode.common.strategy.impl;

import com.tcode.common.strategy.Action;
import com.tcode.persistence.model.CodeMirrorTheme;
import com.tcode.persistence.model.SpringUser;

/**
 * Created by Sergey Roshchupkin on 11/13/2015.
 */
public class CmThemeAction implements Action<SpringUser, String> {

    @Override
    public SpringUser execute(SpringUser loggedUser, String value) {
        CodeMirrorTheme type = CodeMirrorTheme.valueOf(value);
        loggedUser.getOptions().setCodeMirrorTheme(type);
        return loggedUser;
    }
}