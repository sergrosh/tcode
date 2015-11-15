package com.tcode.common.strategy.impl;

import com.tcode.common.strategy.Action;
import com.tcode.persistence.model.Tool;

/**
 * Created by Sergey on 11/13/2015.
 */
public class ToolTitleAction implements Action<Tool, String> {
    @Override
    public Tool execute(Tool entity, String value) {
        entity.setName(value);
        return entity;
    }
}
