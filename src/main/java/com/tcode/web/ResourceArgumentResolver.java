package com.tcode.web;

import com.tcode.common.Constants;
import com.tcode.persistence.model.Resource;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by Sergey on 11/25/2015.
 */
@Component
public class ResourceArgumentResolver extends AbstractHandlerMethodArgumentResolver implements Constants {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Resource.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Resource resource = new Resource();
        resource.setTitle(getTrimmedParameter(webRequest, RESOURCE_TITLE));
        resource.setLink(getTrimmedParameter(webRequest, RESOURCE_LINK));
        resource.setCategory(getTrimmedParameter(webRequest, RESOURCE_CATEGORY));
        resource.setAbout(getTrimmedParameter(webRequest, RESOURCE_ABOUT));

        return resource;
    }
}
