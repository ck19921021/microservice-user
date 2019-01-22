package com.woaipaifang.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

	@Value("${driverClassName}")
	String driverClassName;

	@Value("${user_url}")
	String url;

	@Value("${username}")
	String username;

	@Value("${password}")
	String password;

	@Value("${initialSize}")
	int initialSize;

	@Value("${minIdle}")
	String minIdle;

	@Value("${maxActive}")
	String maxActive;

	@Value("${testOnBorrow}")
	boolean testOnBorrow;

	@Bean
	public DataSource getDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(driverClassName);
		druidDataSource.setUrl(url);
		druidDataSource.setUsername(username);
		druidDataSource.setPassword(password);
		druidDataSource.setInitialSize(initialSize);
		druidDataSource.setTestOnBorrow(testOnBorrow);
		return druidDataSource;
	}
}
