package com.example.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends SecurityConfigurerAdapter {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails nurlan= User.builder()
                .username("nurlan")
                .password("{noop}nurlan123")
                .roles("ADMIN")
                .build();
        UserDetails terlan=User.builder()
                .username("terlan")
                .password("{noop}terlan123")
                .roles("EMPLOYEE")
                .build();
        UserDetails hikmet=User.builder()
                .username("hikmet")
                .password("{noop}hikmet123")
                .roles("EMPLOYEE")
                .build();
        return new InMemoryUserDetailsManager(nurlan,terlan,hikmet);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(congigurer->
                        congigurer
                                .requestMatchers("/cart/**").hasRole("EMPLOYEE")
                                .anyRequest().permitAll());
        return http.build();

    }//Cart endpointine istek atanda 403 forbiden xetasi verir
}
