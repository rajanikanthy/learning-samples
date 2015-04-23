package com.lng.stock.quotes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;

/**
 * 
 * @author RajaniKantha Yammanuru
 *
 */
@Configuration
@EnableIntegration
@ImportResource(("classpath:/stock-quotes-integration-configuration.xml"))
public class StockQuotesIntegrationConfiguration {
	
}
