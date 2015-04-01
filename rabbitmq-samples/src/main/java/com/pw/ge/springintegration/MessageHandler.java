package com.pw.ge.springintegration;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class MessageHandler {
	@ServiceActivator
	public String handleMessage(String message) {
		System.out.println("Received : " + message);
		return "MESSAGE - " + message;
	}
}
