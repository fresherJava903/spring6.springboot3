package com.spring.securityDEMO.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfiguration {

//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
////        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://localhost:3306/student_tracker");
//        dataSourceBuilder.username("springstudent");
//        dataSourceBuilder.password("springstudent");
//        return dataSourceBuilder.build();
//    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password from users where username = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select a.authority " +
                "from authority a join user_authority au on a.authority_id = au.authority_id" +
                "join users u on au.student_id = u.student_id where u.username = ?");
        return jdbcUserDetailsManager;
    }


}
