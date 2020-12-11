package com.rutvi.springsecurity.demo.config;


import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.rutvi.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	// setup variable to hold properties
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// define a bean for viewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	// define a bean for our security datasource
	@Bean
	public DataSource securityDataSource() {
		// create connection pool
		ComboPooledDataSource securityDataSource
						= new ComboPooledDataSource();
		
		// set jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		// log connection props
		logger.info(">>>> jdbc.url " + env.getProperty("jdbc.url"));
		logger.info(">>>> jdbc.user " + env.getProperty("jdbc.user"));
		
		// set database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		securityDataSource.setInitialPoolSize(getIntproperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntproperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntproperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTimeExcessConnections(getIntproperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	// need a helper method
	// read environment property and convert to int
	public int getIntproperty(String propName) {
		String propVal = env.getProperty(propName);
		int intPropVal = Integer.parseInt(propVal);
		return intPropVal;
	}
}
