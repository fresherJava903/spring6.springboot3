package com.springBoot3.spring6.demo.ioc;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{
    @Override
    public String dailyWorkout() {
        return "Shoot 50 times";
    }
}
