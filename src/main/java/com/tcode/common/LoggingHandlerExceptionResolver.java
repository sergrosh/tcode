package com.tcode.common;

import com.tcode.controller.TilesDefinition;
import org.apache.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Sergey Roshchupkin on 11/15/2015.
 */

public class LoggingHandlerExceptionResolver implements HandlerExceptionResolver, Ordered {
    private Logger logger = Logger.getLogger(LoggingHandlerExceptionResolver.class);

    public int getOrder() {
        return 1;
    }

    public ModelAndView resolveException(HttpServletRequest aReq, HttpServletResponse aRes,
                                         Object aHandler, Exception anExc) {
        printExc(anExc);
        return new ModelAndView(TilesDefinition.ERROR_PAGE);
    }

    private void printExc(Throwable exc) {
        Throwable child;
        logger.error(exc.getMessage(), exc);
        for (int i = 0; i < 4; i++) {
            if ((child = exc.getCause()) != null) {
                logger.error(child.getMessage(), child);
            }
        }
    }
}
