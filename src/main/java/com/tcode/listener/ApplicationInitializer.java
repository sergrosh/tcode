package com.tcode.listener;

import com.tcode.common.Constants;
import com.tcode.common.JspConstants;
import com.tcode.controller.Mappings;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Sergey Roshchupkin on 11/8/2015.
 */
public class ApplicationInitializer implements ServletContextListener {

    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        initDeveloperEnvVar(sce);
        initMappings(sce);
        initConstants(sce);
    }

    private void initConstants(ServletContextEvent sce) {
        try {
            sce.getServletContext().setAttribute("Constants", new JspConstants(Constants.class));
        } catch (IllegalAccessException ignored) {
        }
    }

    private void initMappings(ServletContextEvent sce) {
        try {
            sce.getServletContext().setAttribute("Mappings", new JspConstants(Mappings.class, sce.getServletContext().getContextPath()));
        } catch (IllegalAccessException ignored) {
        }
    }

    private void initDeveloperEnvVar(ServletContextEvent sce) {
        String isDeveloperEnv = System.getProperty("isDeveloperEnv");
        if (isDeveloperEnv != null) {
            logger.info("Is it production? " + !Boolean.parseBoolean(isDeveloperEnv));
            sce.getServletContext().setAttribute("isDeveloperEnv", Boolean.parseBoolean(isDeveloperEnv));
        } else {
            logger.info("Is it production? true");
            sce.getServletContext().setAttribute("isDeveloperEnv", false);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}

