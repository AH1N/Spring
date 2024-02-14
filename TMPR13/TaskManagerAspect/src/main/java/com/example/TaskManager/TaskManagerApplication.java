package com.example.TaskManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TaskManagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(TaskManagerApplication.class, args);
	}

}
