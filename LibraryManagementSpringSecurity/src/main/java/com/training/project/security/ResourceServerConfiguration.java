package com.training.project.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{

	private static final String RESOURCE_ID = "my_rest_api";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {

		resources.resourceId(RESOURCE_ID);

	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http
		.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/api/v1/lms/**").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/api/v1/lms/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/v1/lms/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/api/v1/lms/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST,"/api/v2/lms/**").hasRole("USER")
		.antMatchers(HttpMethod.PUT,"/api/v2/lms/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/ap2/v1/lms/**").hasRole("ADMIN")
		.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());

	}

}