package com.kneerecoveryhelper.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
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
    auth.jdbcAuthentication()
        .dataSource(dataSource)
        .passwordEncoder(NoOpPasswordEncoder.getInstance())
        .usersByUsernameQuery("select email, password, enabled from patients where email=?")
        .authoritiesByUsernameQuery("select p.email, r.roles from patients p inner join roles r "
            + "on p.id = r.user_id where p.email=?");
  }

}
