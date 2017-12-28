package org.hao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
        // we don't need CSRF because our token is invulnerable
        .csrf().disable()

        .authorizeRequests()
        // allow anonymous resource requests
	        .antMatchers("/", "/").permitAll()
	        .antMatchers("/admin/**").hasRole("ADMIN")
	        .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
	        .and()
        .formLogin()
        	.loginPage("/login")
        	.permitAll()
        	.usernameParameter("username")
        	.passwordParameter("password")
	        .failureUrl("/login?wrongPassword")
	        .successForwardUrl("/home")
	        .and()
        .logout()
        	.permitAll()
        	.logoutSuccessUrl("/login?logout")
        	.and()
    	.exceptionHandling()
			.accessDeniedPage("/access-denied");
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**");
	}
	
	
	/*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
    }*/
	
}
