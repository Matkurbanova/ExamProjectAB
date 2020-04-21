package com.bermet.ExamProjectAB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamProjectAbApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(ExamProjectAbApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

	}
}
