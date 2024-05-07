package com.project.videopedia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;

@SpringBootApplication
public class VideopediaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VideopediaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		DefaultDataBufferFactory sharedInstance = DefaultDataBufferFactory.sharedInstance;
	}

}
