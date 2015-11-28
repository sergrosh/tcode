package com.tcode.web;

import com.tcode.common.Constants;
import com.tcode.persistence.model.Tool;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by Sergey on 11/25/2015.
 */
@Component
public class ToolArgumentResolver extends AbstractHandlerMethodArgumentResolver implements Constants {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Tool.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Tool tool = new Tool();
        tool.setName(getTrimmedParameter(webRequest, TOOL_NAME));
        tool.setLink(getTrimmedParameter(webRequest, TOOL_LINK));
        tool.setCategory(getTrimmedParameter(webRequest, TOOL_CATEGORY));
        tool.setAbout(getTrimmedParameter(webRequest, TOOL_ABOUT));

        return tool;
    }
}

