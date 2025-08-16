package com.wipro.akshay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BloodUnitServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodUnitServiceApplication.class, args);
	}

}
