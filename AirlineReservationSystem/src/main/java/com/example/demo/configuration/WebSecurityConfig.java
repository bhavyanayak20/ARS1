/*package com.example.demo.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//		return authConfig.getAuthenticationManager();
//	}
	
	@Bean
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	    	.requestMatchers("/").permitAll()
	    	.requestMatchers("/user/login").permitAll()
	        .requestMatchers("/user/register").permitAll()
	        .requestMatchers("/home").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
	        .anyRequest().authenticated()
	        .and()
	        .csrf().disable().formLogin()
	        .loginPage("/login")
	        .failureUrl("/login?error=true")
	        .and()
	        .logout()
	        .logoutRequestMatcher(new AntPathRequestMatcher("logout"))
	        .logoutSuccessUrl("/").and()
	        .exceptionHandling()
	        .accessDeniedPage("/access-denied");
	    
	    return http.build();
	  }

} */
