package com.example.student_catalog_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StudentCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCatalogServiceApplication.class, args);
	}

}
