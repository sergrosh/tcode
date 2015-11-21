package com.tcode.validator;

import com.tcode.persistence.model.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by sroshchupkin on 20/11/15.
 */

@Component
public class ResourceValidator {
    public boolean isValid(Resource resource){
        if(StringUtils.isEmpty(resource.getTitle())){
            return false;
        }
        if(StringUtils.isEmpty(resource.getLink())){
            return false;
        }
        return !StringUtils.isEmpty(resource.getCategory());
    }
}
