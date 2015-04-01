package com.pw.ge.rabbitmq;


public class AlertHandler {
	public void handleAlert(Message message) {
		System.out.println("Handle Message called");
		message.handleMessage();
	}
}
