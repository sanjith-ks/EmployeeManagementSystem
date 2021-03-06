package com.employee.management.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 
 *@author Sanjith
 * @version 26-4-2022
 */
@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
	
	Logger log= LoggerFactory.getLogger(ApplicationSecurity.class);
	
	/**
	 * UserDetailsService object
	 */
	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
		log.info("User logged in.");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests()
		  .antMatchers("/hr/**").hasAnyRole("ADMIN","HR")
		  .antMatchers("/employee/**").permitAll()
		  .and().formLogin().defaultSuccessUrl("/swagger-ui.html",true)
		  .and().logout().clearAuthentication(true).invalidateHttpSession(true)
		  ;
		
		log.info("Authorization is handled");
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
