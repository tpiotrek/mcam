package pl.mcam.web.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import pl.mcam.web.auth.Md5Encoder;
import pl.mcam.web.auth.UserDetailsServiceImpl;

/**
 * 
 * @author Tokarz Piotr
 *
 */
@Configuration
public class BeansConfiguration {
	
	@Bean(name="propertyConfigurer")
	public PropertyPlaceholderConfigurer propertyConfigurer() {
		final ClassPathResource[] resources = {
				new ClassPathResource("database.properties")
		};
		
		final PropertyPlaceholderConfigurer propertyConfigurer = new PropertyPlaceholderConfigurer();
		propertyConfigurer.setLocations(resources);
		propertyConfigurer.setIgnoreUnresolvablePlaceholders(true);
		
		return propertyConfigurer;
	}
	
	@Bean(name="messageSource")
	public ReloadableResourceBundleMessageSource messageSource() {
		final ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.setBasename("classpath:messages");
		source.setDefaultEncoding("UTF-8");
		return source;
	}
	
	@Bean(name="userDetailsService")
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean(name="passwordEncoder")
	public PasswordEncoder passwordEncoder() {
		return new Md5Encoder();
	}
}
