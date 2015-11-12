package com.tcode.persistence.repository.tool;

import com.tcode.persistence.model.Tool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by sroshchupkin on 11/11/15.
 */
public interface ToolRepositoryCustom {

    boolean isExistsByName(String name);

    Set<String> findCategories(boolean isPublished);

    Map<String, List<Tool>> findGroupByCategories(boolean isPublished);

    Set<String> findAllCategories();
}
