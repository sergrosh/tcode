package com.tcode.common.strategy.impl;

import com.tcode.common.strategy.Action;
import com.tcode.persistence.model.SiteTheme;
import com.tcode.persistence.model.SpringUser;

/**
 * Created by Sergey on 11/13/2015.
 */
public class SiteThemeAction implements Action<SpringUser, String> {
    @Override
    public SpringUser execute(SpringUser loggedUser, String value) {
        SiteTheme type = SiteTheme.valueOf(value);
        loggedUser.getOptions().setSiteTheme(type);
        return loggedUser;
    }
}