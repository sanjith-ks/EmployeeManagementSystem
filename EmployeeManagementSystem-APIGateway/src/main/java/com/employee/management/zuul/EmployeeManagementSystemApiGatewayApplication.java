package com.employee.management.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class EmployeeManagementSystemApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApiGatewayApplication.class, args);
	}

}
