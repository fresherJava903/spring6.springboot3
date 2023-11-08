package com.springBoot3.spring6.REST.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

   @Bean
   public InMemoryUserDetailsManager userDetailsManager() {
       UserDetails user1 = User.builder().username("root").password("{noop}root").roles("ROOT", "ADMIN", "USER").build();
       UserDetails user2 = User.builder().username("admin").password("{noop}admin").roles("ADMIN", "USER").build();
       UserDetails user3 = User.builder().username("user").password("{noop}user").roles("USER").build();
       return new InMemoryUserDetailsManager(user1, user2, user3);
   }

   @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http.authorizeHttpRequests(configure ->
               configure
                       .requestMatchers(HttpMethod.GET,"/student/all").hasRole("USER")
                       .requestMatchers(HttpMethod.POST,"/student/add").hasRole("ADMIN")
                       .requestMatchers(HttpMethod.DELETE,"/student/delete").hasRole("ROOT"));
       http.httpBasic(Customizer.withDefaults());

        //Cross site request forgery (CSRF)
       http.csrf(csrf -> csrf.disable());
       return http.build();
   }
}
