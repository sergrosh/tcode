package com.tcode.common.strategy.impl;

import com.tcode.common.strategy.Action;
import com.tcode.persistence.model.ArticleModel;

/**
 * Created by Sergey Roshchupkin on 11/7/2015.
 */
public class AboutAction implements Action<ArticleModel , String> {
    @Override
    public ArticleModel execute(ArticleModel entity, String value) {
        entity.setAbout(value);
        return entity;
    }
}
