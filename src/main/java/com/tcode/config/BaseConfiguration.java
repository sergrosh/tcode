package com.tcode.config;

import org.springframework.core.env.Environment;

import javax.inject.Inject;

/**
 * Created by Sergey Roshchupkin on 11/7/2015.
 */
public class BaseConfiguration {

    @Inject
    protected Environment environment;

}
