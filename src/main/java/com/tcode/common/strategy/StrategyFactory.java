package com.tcode.common.strategy;

import com.tcode.common.Constants;
import com.tcode.common.strategy.impl.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergey on 11/13/2015.
 */
@Component
public class StrategyFactory implements Constants {

    public Map<String, Action> createToolStrategyContext() {
        Map<String, Action> strategyContext = new HashMap<>();
        strategyContext.put(TOOL_ABOUT, new AboutAction());
        strategyContext.put(TOOL_IS_PUBLISHED, new PublishAction());
        strategyContext.put(TOOL_LINK, new LinkAction());
        strategyContext.put(TOOL_NAME, new ToolTitleAction());
        strategyContext.put(TOOL_CATEGORY, new CategoryAction());
        return strategyContext;
    }

    public Map<String, Action> createUserStrategyContext() {
        Map<String, Action> strategyContext = new HashMap<>();
        strategyContext.put(CM_THEME, new CmThemeAction());
        strategyContext.put(SITE_THEME, new SiteThemeAction());
        strategyContext.put(SH_THEME, new ShThemeAction());
        return strategyContext;
    }

    public Map<String, Action> createResourceStrategyContext() {
        Map<String, Action> strategyContext = new HashMap<>();
        strategyContext.put(RESOURCE_ABOUT, new AboutAction());
        strategyContext.put(RESOURCE_IS_PUBLISHED, new PublishAction());
        strategyContext.put(RESOURCE_LINK, new LinkAction());
        strategyContext.put(RESOURCE_TITLE, new ResourceTitleAction());
        strategyContext.put(RESOURCE_CATEGORY, new CategoryAction());
        return strategyContext;
    }

    public Map<String, Action> createTechnologyStrategyContext() {
        Map<String, Action> strategyContext = new HashMap<>();
        strategyContext.put(TECHNOLOGY_ABOUT, new AboutAction());
        strategyContext.put(TECHNOLOGY_IS_PUBLISHED, new PublishAction());
        strategyContext.put(TECHNOLOGY_LINK, new LinkAction());
        strategyContext.put(TECHNOLOGY_NAME, new ResourceTitleAction());
        strategyContext.put(TECHNOLOGY_CATEGORY, new CategoryAction());
        return strategyContext;
    }
}
