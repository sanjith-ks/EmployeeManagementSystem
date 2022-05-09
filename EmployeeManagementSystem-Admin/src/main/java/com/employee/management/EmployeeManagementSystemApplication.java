package com.employee.management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * @author Sanjith
 * @version 27-4-2022
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
public class EmployeeManagementSystemApplication {
	
	private static final Logger log=LoggerFactory.getLogger(EmployeeManagementSystemApplication.class);
	
	@Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build();
    }

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);	
		log.info("Employee Admin Service Has Started.");

	}

}
