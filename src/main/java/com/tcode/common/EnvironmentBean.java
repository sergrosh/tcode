package com.tcode.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sergey Roshchupkin on 11/7/2015.
 */
@Component
public class EnvironmentBean {
    private Set<String> roles;

    @Autowired
    private Environment environment;

    public String getProperty(String key) {
        return get(key);
    }

    public String get(String key) {
        return environment.getProperty(key);
    }

    public int getInt(String key) {
        return Integer.parseInt(environment.getProperty(key));
    }

    public boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    public Integer getPageSize() {
        return getInt("pagination.page.size");
    }

    public boolean isProduction() {
        return getBoolean("env.production");
    }

    public String getShortenerFullUrl() {
        return get("google.shortener.api.url") + get("google.app.key");
    }

    public Set<String> getRoles() {
        if (roles == null) {
            roles = new HashSet<>(Arrays.asList(get("security.roles").split(",")));
        }
        return roles;
    }
}
