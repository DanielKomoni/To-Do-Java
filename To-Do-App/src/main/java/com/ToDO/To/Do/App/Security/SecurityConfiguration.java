  package com.ToDO.To.Do.App.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

  @Configuration
public class SecurityConfiguration {


      @Bean
      public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http.csrf().disable();

            http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated().and()
                    .formLogin().loginPage("/login").permitAll().and().logout().permitAll();



          return http.build();
      }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("u")
                .password("1")
                .roles("USER")
                .build();


        return new InMemoryUserDetailsManager(user);
    }



}