package com.lng.stock.quotes;

import java.util.Enumeration;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author RajaniKantha Yammanuru
 *
 */
@ComponentScan
@EnableAutoConfiguration
public class Application {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(Application.class);

	public static void main(String[] args) {
		Properties p = System.getProperties();
		p.put("http.proxyHost", "proxy-src.research.ge.com");
		p.put("http.proxyPort", "8080");
		Enumeration keys = p.keys();
		while (keys.hasMoreElements()) {
			String key = (String)keys.nextElement();
			String value = (String)p.get(key);
			LOGGER.info("{} = {}", key, value);
		}
		ApplicationContext context = SpringApplication.run(Application.class,
				args);
		

	}
}