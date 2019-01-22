package com.woaipaifang.core.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConf {

	@Value("${queue.signup}")
	String signup;

	@Value("${queue.signin}")
	String signin;

	@Bean
	public Queue signup() {
		return new Queue(signup);
	}

	@Bean
	public Queue signin() {
		return new Queue(signin);
	}

}
