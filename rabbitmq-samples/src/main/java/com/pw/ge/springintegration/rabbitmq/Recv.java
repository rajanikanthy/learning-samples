package com.pw.ge.springintegration.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class Recv {
	private static final String QUEUE_NAME = "hello";
	
	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] To exit press CTRL + c");
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, true, consumer);
		
		while(true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			doWork(message);
			System.out.println(" [x] Received '" + message + "'");
		}
	}
	
	private static void doWork(String message) throws Exception {
		for(char ch : message.toCharArray()) {
			if ( ch == '.') {
				Thread.sleep(1000);
			}
		}
	}
}
