package com.tcode.validator;

import com.tcode.persistence.model.Tool;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Sergey on 11/21/2015.
 */
@Component
public class ToolValidator {

    public boolean isValid(Tool tool) {
        if (StringUtils.isEmpty(tool.getName())) {
            return false;
        }
        if (StringUtils.isEmpty(tool.getLink())) {
            return false;
        }
        return !StringUtils.isEmpty(tool.getCategory());
    }
}
