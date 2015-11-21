package com.tcode.controller;

import com.tcode.persistence.model.Resource;
import com.tcode.persistence.repository.resource.ResourceRepository;
import com.tcode.validator.ResourceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sroshchupkin on 20/11/15.
 */

@Controller
public class ResourceController {

    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private ResourceValidator resourceValidator;

    @RequestMapping(Mappings.RESOURCES_PAGE)
    public ModelAndView resourcesPage() {
        return viewAll();
    }

    @RequestMapping(value = Mappings.SUBMIT_RESOURCE_DO, method = RequestMethod.POST)
    public ModelAndView createResource(Resource resource) {
        List<String> errors = new ArrayList<>();
        if (resourceValidator.isValid(resource)) {
            if (!resourceRepository.isExistsByTitle(resource.getTitle())) {
                resourceRepository.save(resource);
                ModelAndView modelAndView = new ModelAndView(TilesDefinition.CREATE_RESOURCE);
                modelAndView.addObject(resource);
                return modelAndView;
            } else {
                errors.add("Such resource already exists!");
            }
        } else {
            errors.add("Resource is not valid!");
        }
        ModelAndView modelAndView = viewAll();
        modelAndView.addObject("errors", errors);
        return modelAndView;
    }

    public ModelAndView viewAll() {
        ModelAndView modelAndView = new ModelAndView(TilesDefinition.RESOURCES);
        modelAndView.addObject("resourcesMap", resourceRepository.findGroupByCategories(Boolean.TRUE));
        return modelAndView;
    }

    @RequestMapping(value = Mappings.SUBMIT_RESOURCE_PAGE)
    public String createResourcePage() {
        return TilesDefinition.CREATE_RESOURCE;
    }

}
