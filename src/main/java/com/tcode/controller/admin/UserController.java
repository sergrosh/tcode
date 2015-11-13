package com.tcode.controller.admin;

import org.apache.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

/**
 * Created by sroshchupkin on 12/11/15.
 */

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
}
