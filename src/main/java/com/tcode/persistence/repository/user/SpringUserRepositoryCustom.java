package com.tcode.persistence.repository.user;

import com.tcode.persistence.model.SpringUser;

/**
 * Created by Sergey Roshchupkin on 11/11/2015.
 */
public interface SpringUserRepositoryCustom {

    boolean isSpringUserExists(String username, String email);

    boolean isExistsByEmail(String email);

    boolean isExistsByUsername(String username);

    Iterable<SpringUser> search(String search);

}
