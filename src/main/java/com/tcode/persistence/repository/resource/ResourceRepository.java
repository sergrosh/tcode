package com.tcode.persistence.repository.resource;

import com.tcode.persistence.model.Resource;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sergey on 11/15/2015.
 */
@Repository
public interface ResourceRepository extends PagingAndSortingRepository<Resource, String>, ResourceRepositoryCustom, PublishRepository<Resource, String> {

}
