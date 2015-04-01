package com.pw.ge.rabbitmq;

public class AlertMessage implements Message {
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public AlertMessage(String message){
		this.message = message;
	}

	@Override
	public void handleMessage() {
		System.out.println(">>>>>" + message);
	}

}
