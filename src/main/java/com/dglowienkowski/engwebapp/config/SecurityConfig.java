package com.dglowienkowski.engwebapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@EnableWebSecurity
public class SecurityConfig{

	// add a reference to our security data source
	
	@Autowired
	private DataSource securityDataSource;
	
	@Configuration
	@Order(1)
	public class APISecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
			auth.jdbcAuthentication().dataSource(securityDataSource);

		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.antMatcher("/api/**")
			.authorizeRequests()
			.anyRequest().hasAnyRole("USER", "ADMIN")
			.and()
			.httpBasic()
			.and()
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		}
	}
	
	@Configuration
	@Order(2)
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
			auth.jdbcAuthentication().dataSource(securityDataSource);

		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.authorizeRequests()
			.antMatchers("/welcome").permitAll()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/taboocards/**").hasAnyRole("ADMIN", "USER")
			.antMatchers("/headsupcards/**").hasAnyRole("ADMIN", "USER")
			.and()
			.formLogin()
				.loginPage("/showLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		
		}
	}
	
	@Bean
	public UserDetailsManager userDetailsManager() {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		
		jdbcUserDetailsManager.setDataSource(securityDataSource);
		
		return jdbcUserDetailsManager; 
	}
		
}






