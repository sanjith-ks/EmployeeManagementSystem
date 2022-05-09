package com.employee.management.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * 
 * @author Sanjith
 * @version 27-4-2022
 */
@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration

public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
	
	/**
	 * UserDetailsService object
	 */
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		  .antMatchers("/admin/**").hasRole("ADMIN")
		  .and().authorizeRequests()
		  .antMatchers("/finance/**").hasAnyRole("ADMIN","FINANCE")
		  .and().authorizeRequests()
		  .antMatchers("/hr/**").hasAnyRole("ADMIN","HR")
		  .and().authorizeRequests()
		  .antMatchers("/employee/**").permitAll()
		  .and().formLogin().defaultSuccessUrl("/swagger-ui.html")
		  ;
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
