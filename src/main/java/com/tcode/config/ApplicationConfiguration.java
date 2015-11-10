package com.tcode.config;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import java.net.UnknownHostException;

/**
 * Created by Sergey Roshchupkin on 10/11/15.
 */
@Configuration
@EnableCaching
@EnableAsync
@EnableScheduling
@ComponentScan(basePackages = "com.jcoderepository", excludeFilters = {@ComponentScan.Filter(Configuration.class), @ComponentScan.Filter(Controller.class)})
@EnableMongoRepositories("com.jcoderepository.persistence.repository")
@PropertySource({"classpath:application.properties"})
public class ApplicationConfiguration extends BaseConfiguration {


    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        return ehCacheManagerFactoryBean;
    }

    @Bean
    @Inject
    public EhCacheCacheManager cacheManager(EhCacheManagerFactoryBean ehcache) {
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        ehCacheCacheManager.setCacheManager(ehcache.getObject());
        return ehCacheCacheManager;
    }

    @Bean
    public Mongo mongo() throws UnknownHostException {
        return new Mongo(environment.getProperty("mongodb.host"),
                Integer.parseInt(environment.getProperty("mongodb.port")));
    }

    @Bean
    @Autowired
    public MongoDbFactory mongoDbFactory(Mongo mongo) throws UnknownHostException {
        return new SimpleMongoDbFactory(mongo,
                environment.getProperty("mongodb.database.name"));
    }

    @Bean
    @Autowired
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) {
        return new MongoTemplate(mongoDbFactory);
    }
}

