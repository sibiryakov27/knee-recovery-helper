package com.kneerecoveryhelper.configuration;

import com.kneerecoveryhelper.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private UserService userService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
          .antMatchers("/css/**")
          .permitAll()
          .antMatchers("/img/**")
          .permitAll()
          .anyRequest()
          .authenticated()
        .and()
          .formLogin()
          .loginPage("/login")
          .permitAll()
        .and()
          .logout()
          .permitAll();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService)
        .passwordEncoder(NoOpPasswordEncoder.getInstance());
  }

}
