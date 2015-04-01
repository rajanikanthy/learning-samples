package com.pw.ge.springintegration.rabbitmq;

import java.util.Scanner;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {
	private final static String QUEUE_NAME = "hello";
	
	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println("Enter quit to exit");
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String message = scanner.nextLine();
			if (message.equalsIgnoreCase("quit")) {
				break;
			}
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		}
		channel.close();
		connection.close();
	}
}
