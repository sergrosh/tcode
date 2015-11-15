package com.tcode.persistence.repository.resource;

import com.tcode.persistence.model.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sergey on 11/15/2015.
 */
@Repository
public interface ResourceRepositoryCustom {

    boolean isExistsByTitle(String name);

    Set<String> findCategories(boolean isPublished);

    Map<String, List<Resource>> findGroupByCategories(boolean isPublished);

    Set<String> findAllCategories();
}
