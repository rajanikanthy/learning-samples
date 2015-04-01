package com.pw.ge.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class AlertServiceImpl implements AlertService {
	
	private RabbitTemplate rabbit;
	
	@Autowired
	public AlertServiceImpl(RabbitTemplate rabbit) {
		this.rabbit = rabbit;
	}

	@Override
	public void sendAlert(Message message) {
		rabbit.convertAndSend("alerts.queue.exchange", "alert", message);
	}
	
	@Override
	public Message receiveAlert() {
		Message message = (Message)rabbit.receiveAndConvert();
		return message;
	}

}
