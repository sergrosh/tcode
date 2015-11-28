package com.tcode.web;

import com.tcode.common.Constants;
import com.tcode.common.ReCaptchaHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sergey on 11/24/2015.
 */
@Component
public class CaptchaArgumentResolver implements HandlerMethodArgumentResolver, Constants {

    @Autowired
    private ReCaptchaHolder reCaptchaHolder;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Captcha.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        HttpServletRequest nativeRequest = (HttpServletRequest) webRequest.getNativeRequest();
        String challenge = webRequest.getParameter(RECAPTCHA_CHALLENGE_FIELD);
        String response = webRequest.getParameter(RECAPTCHA_RESPONSE_FIELD);

        Captcha.CaptchaBuilder captchaBuilder = new Captcha.CaptchaBuilder();
        captchaBuilder.setPrivateKey(reCaptchaHolder.getPrivateKey());
        captchaBuilder.setRemoteAddr(nativeRequest.getRemoteAddr());
        captchaBuilder.setChallenge(challenge);
        captchaBuilder.setResponse(response);

        return captchaBuilder.build();
    }
}

