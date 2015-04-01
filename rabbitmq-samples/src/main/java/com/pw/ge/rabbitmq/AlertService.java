package com.pw.ge.rabbitmq;

public interface AlertService {
	void sendAlert(Message message);
	Message receiveAlert();
}
