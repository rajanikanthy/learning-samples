package com.pw.ge.springintegration.events.rabbitmq;

public interface EventHandler {
	Object handle(Object...objects) throws Exception;
}
