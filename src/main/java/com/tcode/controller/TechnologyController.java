package com.tcode.controller;

import com.tcode.persistence.model.Technology;
import com.tcode.persistence.repository.technology.TechnologyRepository;
import com.tcode.service.TechnologyService;
import com.tcode.validator.TechnologyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 11/21/2015.
 */
@Controller
public class TechnologyController {
    @Autowired
    private TechnologyService technologyService;
    @Autowired
    private TechnologyRepository technologyRepository;
    @Autowired
    private TechnologyValidator technologyValidator;

    @RequestMapping(Mappings.TECHNOLOGIES_PAGE)
    public ModelAndView technologiesPage() {
        return viewAll();
    }

    @RequestMapping(value = Mappings.SUBMIT_TECHNOLOGY_DO, method = RequestMethod.POST)
    public ModelAndView createTechnology(Technology technology) {
        List<String> errors = new ArrayList<>();
        if (technologyValidator.isValid(technology)) {
            if (!technologyRepository.isExistsByName(technology.getName())) {
                technologyRepository.save(technology);
                ModelAndView modelAndView = new ModelAndView(TilesDefinition.CREATE_TECHNOLOGY);
                modelAndView.addObject(technology);
                return modelAndView;
            } else {
                errors.add("Such technology already registered!");
            }
        } else {
            errors.add("Technology is not valid!");
        }
        ModelAndView modelAndView = viewAll();
        modelAndView.addObject("errors", errors);
        return modelAndView;
    }

    public ModelAndView viewAll() {
        ModelAndView modelAndView = new ModelAndView(TilesDefinition.TECHNOLOGIES);
        modelAndView.addObject("technologiesMap", technologyRepository.findGroupByCategories(true));
        return modelAndView;
    }

    @RequestMapping(value = Mappings.SUBMIT_TECHNOLOGY_PAGE)
    public String createTechnologyPage() {
        return TilesDefinition.CREATE_TECHNOLOGY;
    }
}

