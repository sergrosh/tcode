package com.tcode.controller;

import com.tcode.common.GravatarBean;
import com.tcode.persistence.model.SpringUser;
import com.tcode.persistence.repository.user.SpringUserRepository;
import com.tcode.service.SpringUserService;
import com.tcode.web.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sroshchupkin on 20/11/15.
 */
@Controller
public class SignUpController {

    @Autowired
    private SpringUserService springUserService;

    @Autowired
    private SpringUserRepository springUserRepository;

    @Autowired
    private GravatarBean gravatarBean;

    @RequestMapping(value = Mappings.SIGN_UP_DO, method = RequestMethod.POST)
    public String signUp(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestParam("password") String password,
                         Captcha captcha) {
        if (!springUserRepository.isSpringUserExists(email, username) && captcha.isValid()) {
            SpringUser user = new SpringUser();
            user.setUsername(username);
            user.setEmail(email);
            user.setAvatarUrl(gravatarBean.buildGravatarUrl(email));
            springUserService.saveUser(user, password);
            Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        return TilesDefinition.HOME;
    }
}
