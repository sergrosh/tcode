package com.tcode.controller;

import com.tcode.common.JsonBuilder;
import com.tcode.persistence.model.Tool;
import com.tcode.persistence.repository.tool.ToolRepository;
import com.tcode.service.ToolService;
import com.tcode.validator.ToolValidator;
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
public class ToolController {

    @Autowired
    private ToolRepository toolRepository;
    @Autowired
    private ToolService toolService;
    @Autowired
    private ToolValidator toolValidator;
    @Autowired
    private JsonBuilder jsonBuilder;

    @RequestMapping(Mappings.TOOLS_PAGE)
    public ModelAndView toolsPage() {
        return viewAll();
    }

    @RequestMapping(value = Mappings.SUBMIT_TOOL_DO, method = RequestMethod.POST)
    public ModelAndView createTool(Tool tool) {
        List<String> errors = new ArrayList<>();
        if (toolValidator.isValid(tool)) {
            if (!toolRepository.isExistsByName(tool.getName())) {
                toolRepository.save(tool);
                ModelAndView modelAndView = new ModelAndView(TilesDefinition.CREATE_TOOL);
                modelAndView.addObject("categories", jsonBuilder.toArray(toolService.findPublishedCategories()));
                modelAndView.addObject(tool);
                return modelAndView;
            } else {
                errors.add("Such tool already registered!");
            }
        } else {
            errors.add("Tool is not valid!");
        }
        ModelAndView modelAndView = viewAll();
        modelAndView.addObject("errors", errors);
        return modelAndView;
    }

    public ModelAndView viewAll() {
        ModelAndView modelAndView = new ModelAndView(TilesDefinition.TOOLS);
        modelAndView.addObject("toolsMap", toolRepository.findGroupByCategories(true));
        return modelAndView;
    }

    @RequestMapping(value = Mappings.SUBMIT_TOOL_PAGE)
    public ModelAndView createToolPage() {
        ModelAndView modelAndView = new ModelAndView(TilesDefinition.CREATE_TOOL);
        modelAndView.addObject("categories", jsonBuilder.toArray(toolService.findPublishedCategories()));
        return modelAndView;
    }

}

