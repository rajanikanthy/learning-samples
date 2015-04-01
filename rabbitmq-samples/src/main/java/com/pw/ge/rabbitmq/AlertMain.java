package com.pw.ge.rabbitmq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AlertMain {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("/rabbitmq-context.xml");
		AlertService service = context.getBean(AlertService.class);
		System.out.println("[**] Press Ctrl + C to stop");
		StringBuffer banner = new StringBuffer("*");
		while(true) {
			System.out.println("Sending Message " + banner);
			service.sendAlert(new AlertMessage("" + banner));
			banner.append("*");
			Thread.sleep(1000);
		}
	}

}
