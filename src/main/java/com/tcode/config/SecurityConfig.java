package com.tcode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * Created by Sergey Roshchupkin on 11/15/2015.
 */
@Configuration
@ImportResource("classpath:spring-security.xml")
public class SecurityConfig {

    @Bean
    public Md5PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();
    }

    @Bean
    public SaltSource saltSource() {
        ReflectionSaltSource source = new ReflectionSaltSource();
        source.setUserPropertyToUse("username");
        return source;
    }
}