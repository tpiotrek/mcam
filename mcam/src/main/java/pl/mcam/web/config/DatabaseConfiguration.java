package pl.mcam.web.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 * 
 * @author Tokarz Piotr
 *
 */
@Configuration
public class DatabaseConfiguration {
	
	private LocalSessionFactoryBean sessionFactory;
	
	@Bean(name="dataSource")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(jdbcDriverClassName);
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(jdbcUsername);
		dataSource.setPassword(jdbcPassword);
		
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public LocalSessionFactoryBean sessionFactory() {
		if(this.sessionFactory == null) {
			Properties hibernateProperties = new Properties();
			hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
			hibernateProperties.setProperty("hibernate.show_sql", "true");
		
			LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
			sessionFactory.setDataSource(dataSource());
			sessionFactory.setPackagesToScan("pl.mcam.web.domain");
			sessionFactory.setHibernateProperties(hibernateProperties);
			this.sessionFactory = sessionFactory;
		}
		return this.sessionFactory;
	}
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		
		return transactionManager;
	}
	

	@Value("${jdbc.driverClassName}")
	private String jdbcDriverClassName;
	
	@Value("${jdbc.url}")
	private String jdbcUrl;
	
	@Value("${jdbc.username}")
	private String jdbcUsername;
	
	@Value("${jdbc.password}")
	private String jdbcPassword;
}
