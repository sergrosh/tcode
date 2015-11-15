package com.tcode.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Sergey on 11/15/2015.
 */
@Component
public class ReCaptchaHolder {

    private String publicKey;
    private String privateKey;

    @Autowired
    private EnvironmentBean environmentBean;

    @PostConstruct
    private void init() {
        if (environmentBean.getBoolean("isDeveloperEnv")) {
            publicKey = environmentBean.get("test.captcha.public.key");
            privateKey = environmentBean.get("test.captcha.private.key");
        } else {
            publicKey = environmentBean.get("production.captcha.public.key");
            privateKey = environmentBean.get("production.captcha.private.key");
        }
    }

    public String getPublicKey() {
        return publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

}
