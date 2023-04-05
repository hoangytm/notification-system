package com.hoangyth.scheduler;

import com.hoangyth.model.User;
import com.hoangyth.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Configuration
public class TestScheduler {
    private final UserService userService;

    public TestScheduler(UserService userService) {
        this.userService = userService;
    }

    @Scheduled(fixedRate = 1000)
    @Async
    public void scheduleFixedRateWithInitialDelayTask() {
        System.out.println("----------------------Time start "+ (new Date()).toString());
        userService.getUserByUserName("hoang");
        System.out.println("----------------------Time end "+ (new Date()).toString());
    }

}
