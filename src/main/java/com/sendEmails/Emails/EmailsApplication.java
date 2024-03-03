package com.sendEmails.Emails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EmailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailsApplication.class, args);
	}

}
