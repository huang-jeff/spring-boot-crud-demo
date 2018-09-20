package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.rabbitmq.Receiver;
import com.example.demo.rabbitmq.Sender;

@RestController
@RequestMapping("/api")
public class RabbitRestController {

	@GetMapping("/rabbitsend")
	public String sendMessage() {
		System.out.println("--- : sending AMQP message");
		try {
			Sender.send();
		} catch (Exception e) {
			System.err.println("*** : " + e);
		}
		return "Sending! stuff is happening in console... go look there!";
	}
	
	@GetMapping("/rabbitrecv")
	public String recvMessage() {
		System.out.println("--- : receiving AMQP message");
		try {
			Receiver.receive();
		} catch (Exception e) {
			System.err.println("*** : " + e);
		}
		return "Receiving? stuff is happening in console...go look there!";
	}
}
