package com.tcode.persistence.repository.technology;

import com.tcode.persistence.model.Technology;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sergey on 11/15/2015.
 */
public interface TechnologyRepositoryCustom {

    boolean isExistsByName(String name);

    Set<String> findCategories(boolean isPublished);

    Map<String, List<Technology>> findGroupByCategories(boolean isPublished);

    Set<String> findAllCategories();
}
