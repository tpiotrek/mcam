package pl.mcam.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {				
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/users/index.html").hasRole("ADMIN")
				.antMatchers("/users/process").hasRole("ADMIN")
				.anyRequest().permitAll()
				.and()
			.formLogin()
				.loginPage("/login/index.html")
				.loginProcessingUrl(PROCESSING_URL)
				.defaultSuccessUrl("/")
				.failureUrl("/login/index.html?error")
				.passwordParameter("password")
				.usernameParameter("username")
				.permitAll()
				.and()
			.logout()  
				.logoutUrl("/login/logout")
                .permitAll();
	}
	
	@Autowired(required=true)
	private DataSource dataSource;
	
	@Autowired(required=true)
	private UserDetailsService userDetailsService;
	
	@Autowired(required=true)
	private PasswordEncoder passwordEncoder;
	
	private final static String PROCESSING_URL = "/login/process"; 
}
