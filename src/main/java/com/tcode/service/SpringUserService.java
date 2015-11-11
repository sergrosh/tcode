package com.tcode.service;

import com.tcode.persistence.model.SpringUser;
import com.tcode.persistence.repository.user.SpringUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Sergey Roshchupkin on 11/11/2015.
 */
@Service
public class SpringUserService {

    private SpringUserRepository springUserRepository;
    private PasswordEncoder passwordEncoder;
    private SaltSource saltSource;

    @Autowired
    public SpringUserService(SpringUserRepository springUserRepository, PasswordEncoder passwordEncoder, SaltSource saltSource) {
        this.springUserRepository = springUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.saltSource = saltSource;
    }

    public void saveUser(SpringUser springUser, String originalPassword) {
        Object salt = saltSource.getSalt(springUser);
        String hash = passwordEncoder.encodePassword(originalPassword, salt);
        springUser.setPassword(hash);
        springUserRepository.save(springUser);
    }
}