package com.tcode.controller.admin;

import com.tcode.controller.Mappings;
import com.tcode.controller.Message;
import com.tcode.controller.TilesDefinition;
import com.tcode.persistence.model.SpringUser;
import com.tcode.persistence.repository.user.SpringUserRepository;
import com.tcode.service.SpringUserService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by sroshchupkin on 12/11/15.
 */

@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private SpringUserService userService;
    @Autowired
    private SpringUserRepository springUserRepository;

    @RequestMapping(Mappings.ADMIN_USER_LIST)
    public String listUsers(@RequestParam(value = "search", required = false)
                            String search, Model model) {
        model.addAttribute("users", springUserRepository.search(search));
        model.addAttribute("search", search);
        return TilesDefinition.ADMIN_USER_LIST;
    }

    @RequestMapping(value = Mappings.ADMIN_USER_DO, method = RequestMethod.POST)
    public String update(@RequestParam("encryptedPassword") String encryptedPassword, @Valid SpringUser user,
                         BindingResult bindingResult, Model uiModel, RedirectAttributes redirectAttributes) {
        logger.info("Updating user");
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("message", new Message ("error", "some error"));
            uiModel.addAttribute("user", user);
            return TilesDefinition.ADMIN_USER_EDIT;
        }
        uiModel.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success", "User updated success!"));
        if (StringUtils.isNotEmpty(encryptedPassword)) {
            userService.saveUser(user, encryptedPassword);
        } else {
            springUserRepository.save(user);
        }
        return "redirect:" + Mappings.ADMIN_USER_LIST;
    }

    @RequestMapping(value = Mappings.ADMIN_USER_PAGE, method = RequestMethod.GET)
    public String updateForm(@RequestParam("id") String id, Model uiModel) {
        uiModel.addAttribute("user", springUserRepository.findOne(id));
        return TilesDefinition.ADMIN_USER_EDIT;
    }
}
