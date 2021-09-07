package com.htc.clinicmanagementr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClinicManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicManagementApplication.class, args);
	}

}
