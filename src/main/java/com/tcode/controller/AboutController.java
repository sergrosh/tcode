package com.tcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sergey on 11/15/2015.
 */
@Controller
public class AboutController {

    @RequestMapping(Mappings.ABOUT_PAGE)
    public String aboutPage() {
        return TilesDefinition.ABOUT;
    }
}

