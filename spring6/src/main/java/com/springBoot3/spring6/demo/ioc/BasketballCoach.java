package com.springBoot3.spring6.demo.ioc;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BasketballCoach implements Coach{
    @Override
    public String dailyWorkout() {
        return "Run 20 rounds around the yard!";
    }

//    @PostConstruct
    public void sayHello() {
        System.out.println("Hi, Hanamichi!");
    }

//    @PreDestroy
    public void sayGoodBye() {
        System.out.println("Hanamichi, baka!");
    }
}
