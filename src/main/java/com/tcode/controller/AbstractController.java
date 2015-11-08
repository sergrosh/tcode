package com.tcode.controller;

import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by Sergey Roshchupkin on 11/8/2015.
 */
public abstract class AbstractController {

    protected static final String MESSAGES_MODEL = "messages";
    protected static final String ERRORS_MODEL = "errors";

    public ModelAndView getMessagesModel(String view) {
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject(MESSAGES_MODEL, new ArrayList<String>());
        return modelAndView;
    }

    public ModelAndView getErrorsModel(String view) {
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject(ERRORS_MODEL, new ArrayList<String>());
        return modelAndView;
    }

    public ModelAndView addErrorsModel(ModelAndView modelAndView) {
        modelAndView.addObject(ERRORS_MODEL, new ArrayList<String>());
        return modelAndView;
    }
}