package com.cg.productcartmanagementSystem_152621;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EntityScan("com.cg.model")
@EnableJpaRepositories("com.cg.productRepo")
@ComponentScan("com.cg")
@SpringBootApplication
public class ProductCartManagementSystem152621Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductCartManagementSystem152621Application.class, args);
	}
}
