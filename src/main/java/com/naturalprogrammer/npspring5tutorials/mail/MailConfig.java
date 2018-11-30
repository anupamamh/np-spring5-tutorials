package com.naturalprogrammer.npspring5tutorials.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

	@Bean
	public DemoBean demoBean() {
		return new DemoBean();
	}

	
	@Bean
	//@Profile("dev")
	@ConditionalOnProperty(name="spring.mail.host",
	havingValue="foo" , matchIfMissing=true)
	public MailSender mockMailSender() {

		return new MockMailSender();
	}

	@Bean
	//@Profile("!dev")
	@ConditionalOnProperty("spring.mail.host")
	public MailSender smtpMailSender(JavaMailSender javaMailSender) {

		return new SmtpMailSender(javaMailSender);
	}
}
