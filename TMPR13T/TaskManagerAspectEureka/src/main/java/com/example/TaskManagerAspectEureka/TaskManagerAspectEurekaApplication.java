package com.example.TaskManagerAspectEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class TaskManagerAspectEurekaApplication {

	public static void main(String[] args) {

		SpringApplication.run(TaskManagerAspectEurekaApplication.class, args);
	}

}
