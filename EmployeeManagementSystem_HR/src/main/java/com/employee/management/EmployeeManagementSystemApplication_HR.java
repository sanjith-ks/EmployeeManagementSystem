package com.employee.management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * @author Sanjith
 * @version 26-4-2022
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class EmployeeManagementSystemApplication_HR {
	
	 static Logger log=LoggerFactory.getLogger(EmployeeManagementSystemApplication_HR.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication_HR.class, args);
		log.info("HR Service has Started.");
	}

}
