package com.naturalprogrammer.npspring5tutorials.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MockMailSender implements MailSender {

	private static Log log = LogFactory.getLog(MockMailSender.class);

	@Override
	public void send(String to, String subject, String body) {
		log.info("Sending MockMail to :" + to);
		log.info("With Subject : " + subject);
		log.info("and  " + body);
	}

}
