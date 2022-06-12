package com.TrabajoFinal.IgnaShop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userDetailsServiceImpl")
	private UserDetailsServiceImpl userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/user/confirm-account").permitAll()
		.antMatchers("/public/articles","/img/**","/assets/**","/css/**","/js/**","/public/**","/static/**","/vendor/**").permitAll()
		.antMatchers("/public/articlesOrder","/img/**","/assets/**","/css/**","/js/**","/public/**","/static/**","/vendor/**").permitAll()
		.antMatchers("/public/guest","/img/**","/assets/**","/css/**","/js/**","/public/**","/static/**","/vendor/**").permitAll()
		.antMatchers("/public/articlesOrder").permitAll()
		.antMatchers("/auth/login","/user/register","/user/Myarticles**","/img/**","/assets/**","/css/**","/js/**","/public/**","/static/**","/vendor/**","/auth/**").permitAll().anyRequest().authenticated()
			
				
				.and().formLogin().loginPage("/public/guest")
				.usernameParameter("email").defaultSuccessUrl("/", true).failureUrl("/auth/login?error=true")
				.loginProcessingUrl("/auth/login-post").permitAll().and().logout().logoutUrl("/logout")
				.logoutSuccessUrl("/auth/login?logout").permitAll();
	}
	


}
