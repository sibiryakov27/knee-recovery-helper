package com.kneerecoveryhelper.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  DataSource dataSource;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource(dataSource);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/").hasRole("PATIENT")
        .antMatchers("/about-system").hasRole("PATIENT")
        .antMatchers("/exercises").hasRole("PATIENT")
        .antMatchers("/profile").hasRole("PATIENT")
        .antMatchers("/test-eq5d3l").hasRole("PATIENT")
        .antMatchers("/test-oks").hasRole("PATIENT")
        .and().formLogin().permitAll();
  }
}
