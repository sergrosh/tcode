package com.tcode.web;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

/**
 * Created by sroshchupkin on 20/11/15.
 */
public class Captcha {

    private String privateKey;
    private String challenge;
    private String response;
    private String remoteAddr;

    private Captcha(String privateKey, String challenge, String response, String remoteAddr) {
        this.privateKey = privateKey;
        this.challenge = challenge;
        this.response = response;
        this.remoteAddr = remoteAddr;
    }

    public boolean isValid() {
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey(privateKey);
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, response);
        return reCaptchaResponse.isValid();
    }

    public static class CaptchaBuilder {
        private String privateKey;
        private String challenge;
        private String response;
        private String remoteAddr;

        public CaptchaBuilder setPrivateKey(String privateKey) {
            this.privateKey = privateKey;
            return this;
        }

        public CaptchaBuilder setChallenge(String challenge) {
            this.challenge = challenge;
            return this;
        }

        public CaptchaBuilder setResponse(String response) {
            this.response = response;
            return this;
        }

        public CaptchaBuilder setRemoteAddr(String remoteAddr) {
            this.remoteAddr = remoteAddr;
            return this;
        }

        public Captcha build() {
            return new Captcha(privateKey, challenge, response, remoteAddr);
        }
    }
}
