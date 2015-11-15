package com.tcode.controller;

import com.tcode.common.PaginationBean;
import com.tcode.persistence.repository.technology.TechnologyRepository;
import com.tcode.persistence.repository.tool.ToolRepository;
import com.tcode.persistence.repository.user.SpringUserRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Sergey on 11/15/2015.
 */
@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    @Autowired
    private ToolRepository toolRepository;
    @Autowired
    private TechnologyRepository technologyRepository;
    @Autowired
    private ResourceRepository  resourceRepository;
    @Autowired
    private SpringUserRepository userRepository;
    @Autowired
    private PaginationBean paginationBean;

    @RequestMapping(Mappings.ADMIN_SUBMITTED_TOOLS_PAGE)
    public ModelAndView submittedTools() {
        ModelAndView modelAndView = new ModelAndView(TilesDefinition.SUBMITTED_TOOLS);
        modelAndView.addObject("tools", toolRepository.findByPublished(false));
        return modelAndView;
    }

    @RequestMapping(Mappings.ADMIN_DELETE_TOOL_DO)
    public ModelAndView deleteTool(@RequestParam String toolId) {
        toolRepository.delete(toolId);
        return submittedTools();
    }

    @RequestMapping(Mappings.ADMIN_SUBMITTED_RESOURCES_PAGE)
    public ModelAndView submittedResources() {
        ModelAndView modelAndView = new ModelAndView(TilesDefinition.SUBMITTED_RESOURCES);
        modelAndView.addObject("resources", resourceRepository.findByPublished(false));
        return modelAndView;
    }

    @RequestMapping(Mappings.ADMIN_DELETE_RESOURCE_DO)
    public ModelAndView deleteResource(@RequestParam String resourceId) {
        resourceRepository.delete(resourceId);
        return submittedResources();
    }

    @RequestMapping(Mappings.ADMIN_SUBMITTED_TECHNOLOGIES_PAGE)
    public ModelAndView submittedTechnologies() {
        ModelAndView modelAndView = new ModelAndView(TilesDefinition.SUBMITTED_TECHNOLOGIES);
        modelAndView.addObject("technologies", technologyRepository.findByPublished(false));
        return modelAndView;
    }

    @RequestMapping(Mappings.ADMIN_DELETE_TECHNOLOGY_DO)
    public ModelAndView deleteTechnology(@RequestParam String technologyId) {
        toolRepository.delete(technologyId);
        return submittedTechnologies();
    }

    @RequestMapping(Mappings.ADMIN_USERS_PAGE)
    public ModelAndView users() {
        return load(1);
    }

    @RequestMapping(Mappings.ADMIN_USERS + "/{pageNum}.page")
    public ModelAndView load(@PathVariable int pageNum) {
        ModelAndView modelAndView = new ModelAndView(TilesDefinition.REGISTERED_USERS);
        Page<SpringUser> page = userRepository.findAll(paginationBean.defaultPageable(pageNum - 1));
        modelAndView.addObject("page", page);
        return modelAndView;
    }

    @RequestMapping(Mappings.ADMIN_SET_ROLE_JSON)
    public
    @ResponseBody
    void setRole(@RequestParam("pk") String userId, @RequestParam("value") String role) {
        if (StringUtils.isNotEmpty(userId)) {
            SpringUser user = userRepository.findOne(userId);
            user.getRoles().add(role.toUpperCase());
            userRepository.save(user);
        }
    }
}
