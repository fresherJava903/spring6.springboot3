package com.springBoot3.spring6.demo;

import OtherPackage.entity.Book;
import com.springBoot3.spring6.demo.ioc.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootRest {

    Coach coach;
    Book book;
    // if there is only one implement of Coach interface, @Autowired is optional
    @Autowired
    public SpringBootRest(@Qualifier("basketballCoach") Coach coach) {
        this.coach = coach;
    }

    @Autowired
    public void setBook(Book book) {
        this.book = book;
    }

    @Value("${hello}")
    String hello;

    @GetMapping("/")
    public String sayHello() {
        return hello;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.dailyWorkout();
    }

    @GetMapping("/book")
    public String getAuthor() {
        return book.getAuthor();
    }
}
