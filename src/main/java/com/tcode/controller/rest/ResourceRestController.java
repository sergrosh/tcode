package com.tcode.controller.rest;

import com.tcode.common.JsonBuilder;
import com.tcode.common.strategy.Action;
import com.tcode.common.strategy.StrategyFactory;
import com.tcode.controller.Mappings;
import com.tcode.persistence.model.Resource;
import com.tcode.persistence.repository.resource.ResourceRepository;
import com.tcode.util.AjaxUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Sergey on 11/19/2015.
 */
@Controller
public class ResourceRestController {

    private Map<String, Action> updateResourceActions;

    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private JsonBuilder jsonBuilder;
    @Autowired
    private StrategyFactory strategyFactory;

    @PostConstruct
    private void init() {
        updateResourceActions = strategyFactory.createResourceStrategyContext();
    }

    @RequestMapping(
            value = Mappings.REST_RESOURCE_ENABLE_VALUES_JSON,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Cacheable(value = "small-jsons")
    public
    @ResponseBody
    String codeMirrorThemes() {
        return jsonBuilder.buildEnabledValuesJson();
    }

    @RequestMapping(
            value = Mappings.REST_RESOURCE_CATEGORIES_JSON,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public
    @ResponseBody
    String resourceCategories() {
        ArrayList<String> categories = new ArrayList<>(resourceRepository.findAllCategories());
        StringBuffer buffer = new StringBuffer("[");

        for (int i = 0; i < categories.size(); i++) {
            String category = categories.get(i);
            buffer.append("\"").append(category).append("\"");
            if (i != categories.size() - 1) {
                buffer.append(",");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    @RequestMapping(
            value = Mappings.REST_RESOURCE_UPDATE_JSON,
            method = RequestMethod.POST
    )
    public
    @ResponseBody
    void updateUser(@RequestParam("pk") String resourceId,
                    @RequestParam("name") String name,
                    @RequestParam("value") String value) {
        if (StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(value)) {
            Action action = updateResourceActions.get(name);
            if (action != null) {
                Resource resource = resourceRepository.findOne(resourceId);
                resource = (Resource) action.execute(resource, value);
                resourceRepository.save(resource);
            }
        }
    }

    @ExceptionHandler(Exception.class)
    public
    @ResponseBody
    String handleUncaughtException(Exception ex, WebRequest request, HttpServletResponse response) throws IOException {
        if (AjaxUtils.isAjaxRequest(request)) {
            response.setHeader("Content-Type", "application/json");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Unknown error occurred: " + ex.getMessage();
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
            return null;
        }
    }
}

