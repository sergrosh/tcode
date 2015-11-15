package com.tcode.common.strategy.impl;

import com.tcode.common.strategy.Action;
import com.tcode.persistence.model.Resource;

/**
 * Created by Sergey Roshchupkin on 11/13/2015.
 */
public class ResourceTitleAction implements Action<Resource, String> {
    @Override
    public Resource execute(Resource entity, String value) {
        entity.setTitle(value);
        return entity;
    }
}
