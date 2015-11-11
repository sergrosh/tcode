package com.tcode.persistence.repository.user;

import com.tcode.persistence.model.SpringUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sergey on 11/11/2015.
 */
@Repository
public interface SpringUserRepository extends PagingAndSortingRepository<SpringUser, String>, SpringUserRepositoryCustom {

    SpringUser findByUsername(String username);

    SpringUser  findByEmail(String email);

}