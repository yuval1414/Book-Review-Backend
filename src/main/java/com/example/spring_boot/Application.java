package com.example.spring_boot;//package com.example.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("Book Review Server Starting on port 8080...");
		SpringApplication.run(Application.class, args);
	}

}
