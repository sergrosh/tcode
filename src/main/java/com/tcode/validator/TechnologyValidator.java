package com.tcode.validator;

import com.tcode.persistence.model.Technology;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Sergey on 11/21/2015.
 */
@Component
public class TechnologyValidator {

    public boolean isValid(Technology technology) {
        if (StringUtils.isEmpty(technology.getName())) {
            return false;
        }
        if (StringUtils.isEmpty(technology.getLink())) {
            return false;
        }
        return !StringUtils.isEmpty(technology.getCategory());
    }
}