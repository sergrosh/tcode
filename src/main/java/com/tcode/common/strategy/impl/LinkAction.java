package com.tcode.common.strategy.impl;

import com.tcode.common.strategy.Action;
import com.tcode.persistence.model.ArticleModel;

/**
 * Created by Sergey on 11/13/2015.
 */
public class LinkAction implements Action<ArticleModel, String> {
    @Override
    public ArticleModel execute(ArticleModel entity, String value) {
        entity.setLink(value);
        return entity;
    }
}
