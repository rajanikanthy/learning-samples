package com.pw.ge.rabbitmq;

import java.io.Serializable;

public interface Message extends Serializable {
	void handleMessage();
}
