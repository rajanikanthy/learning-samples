package com.lng.stock.quotes;

import org.springframework.integration.file.FileNameGenerator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class StockOutboundFileNameGenerator implements FileNameGenerator {
	@Override
	public String generateFileName(Message<?> message) {
		return "stock-" + System.currentTimeMillis() + ".csv";
	}

}
