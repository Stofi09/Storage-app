package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth)throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("user")
			.password("{noop}password")
			.roles("USER")
			.and()
				.withUser("userAdmin")
				.password("{noop}password1")
				.roles("ADMIN");
				
	}
	
	@Override
	protected void configure(HttpSecurity httpsec)throws Exception{
		httpsec
			.authorizeRequests()
				.antMatchers(HttpMethod.GET,"/").permitAll()
				.antMatchers("/page2").hasRole("ADMIN")
				.and()
					.formLogin().permitAll();
	}
	
}
