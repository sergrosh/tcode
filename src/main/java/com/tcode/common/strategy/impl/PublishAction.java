package com.tcode.common.strategy.impl;

import com.tcode.common.strategy.Action;
import com.tcode.persistence.model.PublishModel;

/**
 * Created by Sergey on 11/13/2015.
 */
public class PublishAction implements Action<PublishModel, String> {
    @Override
    public PublishModel execute(PublishModel  entity, String value) {
        entity.setPublished(Boolean.valueOf(value));
        return entity;
    }
}