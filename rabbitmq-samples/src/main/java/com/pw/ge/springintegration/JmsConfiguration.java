package com.pw.ge.springintegration;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JmsConfiguration {
	@Bean(name = "connectionFactory")
	public com.rabbitmq.client.ConnectionFactory getConnectionFactory(){
		com.rabbitmq.client.ConnectionFactory factory = new com.rabbitmq.client.ConnectionFactory();
		factory.setHost("localhost");
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(factory);
		cachingConnectionFactory.setChannelCacheSize(10);
		return factory;
	}
}
