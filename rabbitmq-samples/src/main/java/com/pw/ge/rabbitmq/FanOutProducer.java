package com.pw.ge.rabbitmq;

import java.io.IOException;
import java.util.Scanner;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class FanOutProducer {

	private static final String EXCHANGE_NAME = "logs";

	public static void main(String... args) throws IOException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
		System.out.println("Enter quit to exit");
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String message = scanner.nextLine();
			if (message.equalsIgnoreCase("quit")) {
				break;
			}
			channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
		}
		channel.close();
		connection.close();
	}
}
