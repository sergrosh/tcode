package com.tcode.web;

import com.tcode.common.Constants;
import com.tcode.persistence.model.Technology;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by Sergey on 11/25/2015.
 */
@Component
public class TechnologyArgumentResolver extends AbstractHandlerMethodArgumentResolver implements Constants {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Technology.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Technology technology = new Technology();
        technology.setName(getTrimmedParameter(webRequest, TECHNOLOGY_NAME));
        technology.setLink(getTrimmedParameter(webRequest, TECHNOLOGY_LINK));
        technology.setCategory(getTrimmedParameter(webRequest, TECHNOLOGY_CATEGORY));
        technology.setAbout(getTrimmedParameter(webRequest, TECHNOLOGY_ABOUT));

        return technology;
    }
}

