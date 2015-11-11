package com.tcode.listener;

import com.tcode.common.EnvironmentBean;
import com.tcode.persistence.model.SpringUser;
import com.tcode.persistence.repository.user.SpringUserRepository;
import com.tcode.service.SpringUserService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * Created by Sergey on 11/11/2015.
 */
@Component
public class ApplicationListenerBean implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        SpringUserRepository  springUserRepository = event.getApplicationContext().getBean(SpringUserRepository.class);
        EnvironmentBean environmentBean = event.getApplicationContext().getBean(EnvironmentBean.class);

        String email = environmentBean.get("admin.email");
        if (!springUserRepository.isExistsByEmail(email)) {
            SpringUser admin = new SpringUser();
            admin.setEmail(email);
            admin.setUsername(environmentBean.get("admin.username"));

            HashSet<String> roles = new HashSet<>();
            roles.add("ROLE_ADMIN");

            admin.setRoles(roles);
            event.getApplicationContext().getBean(SpringUserService.class).saveUser(admin, environmentBean.get("admin.password"));
        }
    }
}
