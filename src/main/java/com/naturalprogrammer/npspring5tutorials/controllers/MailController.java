package com.naturalprogrammer.npspring5tutorials.controllers;

import javax.mail.MessagingException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturalprogrammer.npspring5tutorials.mail.MailSender;

@RestController
public class MailController {

	private MailSender mailSender;

	public MailController(MailSender smtp) {
		this.mailSender = smtp;
	}

	@RequestMapping("/mail")
	public String mail() throws MessagingException {
		mailSender.send("anupama.guggari@gmail.com", "A Test mail ", "Body Of The Test Mail");
		return "Mail Sent";
	}
}
