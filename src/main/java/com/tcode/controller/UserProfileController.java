package com.tcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sergey on 11/21/2015.
 */
@Controller
@RequestMapping("/user")
public class UserProfileController {

    @RequestMapping(Mappings.PROFILE_PAGE)
    public String profile() {
        return TilesDefinition.PROFILE;
    }
}