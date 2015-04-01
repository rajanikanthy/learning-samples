package com.pw.ge.springintegration.events.rabbitmq;

import java.io.Serializable;

public class Event implements Serializable {
	private static final long serialVersionUID = 1L;
	private String event;
	private EventHandler eventHandler;
	
	public Event(String event, EventHandler eventHandler) {
		this.event = event;
		this.eventHandler = eventHandler;
	}
	
	public String getEvent() {
		return event;
	}
	
	public EventHandler getEventHandler(){
		return eventHandler;
	}
}
