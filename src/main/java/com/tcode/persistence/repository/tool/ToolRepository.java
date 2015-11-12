package com.tcode.persistence.repository.tool;

import com.tcode.persistence.model.Tool;
import com.tcode.persistence.repository.PublishRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sroshchupkin on 11/11/15.
 */
@Repository
public interface ToolRepository extends PagingAndSortingRepository<Tool , String>, ToolRepositoryCustom, PublishRepository<Tool, String> {

}
