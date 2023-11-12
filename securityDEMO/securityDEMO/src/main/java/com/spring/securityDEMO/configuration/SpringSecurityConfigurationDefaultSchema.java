package com.spring.securityDEMO.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration(enforceUniqueMethods = false)
public class SpringSecurityConfigurationDefaultSchema {

    //using in-memory user
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails vuong = User.builder()
                .username("vuong")
                .password("{noop}vuong")
                .roles("EMPLOYEE")
                .build();
        UserDetails quynh = User.builder()
                .username("quynh")
                .password("{noop}quynh")
                .roles("BOSS", "EMPLOYEE")
                .build();
        return new InMemoryUserDetailsManager(vuong, quynh);
    }

    //using datasource for jdbc authentication following default spring schema
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    //using jwt


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure ->
                configure
                        .requestMatchers(HttpMethod.GET,"/student/").permitAll()
                        .requestMatchers(HttpMethod.GET,"/student/get").hasAnyRole("BOSS")
                        .requestMatchers(HttpMethod.GET,"/student/get/**").hasAnyRole("EMPLOYEE"));
        http.httpBasic(Customizer.withDefaults());

        //Cross site request forgery (CSRF)
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }

}
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
//        jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password from users where username = ?");
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select a.authority " +
//                "from authority a join user_authority au on a.authority_id = au.authority_id" +
//                "join users u on au.student_id = u.student_id where u.username = ?");
//        return jdbcUserDetailsManager;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(configure ->
//                configure
//                        .requestMatchers(HttpMethod.GET,"/student/all").hasRole("USER")
//                        .requestMatchers(HttpMethod.POST,"/student/add").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.DELETE,"/student/delete").hasRole("ROOT"));
//        http.httpBasic(Customizer.withDefaults());
//
//        //Cross site request forgery (CSRF)
//        http.csrf(csrf -> csrf.disable());
//        return http.build();
//    }
