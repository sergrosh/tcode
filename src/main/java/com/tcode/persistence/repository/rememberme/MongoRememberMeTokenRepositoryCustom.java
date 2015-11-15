package com.tcode.persistence.repository.rememberme;

/**
 * Created by Sergey on 11/15/2015.
 */
public interface MongoRememberMeTokenRepositoryCustom {
    void removeUserTokens(String username);
}
