package com.tcode.persistence.repository.rememberme;

import com.tcode.persistence.model.MongoRememberMeToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sergey on 11/15/2015.
 */
@Repository
public interface MongoRememberMeTokenRepository extends CrudRepository<MongoRememberMeToken , String>, MongoRememberMeTokenRepositoryCustom {
    MongoRememberMeToken findBySeries(String series);
}
