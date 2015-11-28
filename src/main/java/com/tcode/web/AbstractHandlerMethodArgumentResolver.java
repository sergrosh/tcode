package com.tcode.web;

import com.tcode.common.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

/**
 * Created by Sergey on 11/24/2015.
 */
public abstract class AbstractHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver, Constants {

    public String getTrimmedParameter(NativeWebRequest webRequest, String paramName) {
        String value = webRequest.getParameter(paramName);
        if (StringUtils.isEmpty(value)) {
            return null;
        } else {
            return value.trim();
        }
    }
}
