package com.geisivan.taskservice;

import com.geisivan.taskservice.infrastructure.config.DotenvLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskServiceApplication {

	public static void main(String[] args) {

		DotenvLoader.load();
		SpringApplication.run(TaskServiceApplication.class, args);
	}
}
