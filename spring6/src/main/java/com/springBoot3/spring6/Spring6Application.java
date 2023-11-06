package com.springBoot3.spring6;

import com.springBoot3.spring6.hibernateJPA.service.BankAccountService;
import com.springBoot3.spring6.hibernateJPA.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.springBoot3.spring6", "OtherPackage"})
public class Spring6Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring6Application.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner() {
		return runner -> {
			System.out.println("App started!");
		};
	}
}
