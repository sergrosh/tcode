package com.tcode.util;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by Sergey on 11/19/2015.
 */


public class AjaxUtils {

    private AjaxUtils() {
    }

    public static boolean isAjaxRequest(WebRequest webRequest) {
        String requestedWith = webRequest.getHeader("X-Requested-With");
        return requestedWith != null && "XMLHttpRequest".equals(requestedWith);
    }

}
