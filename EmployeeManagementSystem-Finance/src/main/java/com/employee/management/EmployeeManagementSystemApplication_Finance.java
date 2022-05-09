package com.employee.management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCircuitBreaker
@EnableScheduling
@EnableSwagger2
@EnableEurekaClient
public class EmployeeManagementSystemApplication_Finance {
	
	private static final Logger log=LoggerFactory.getLogger(EmployeeManagementSystemApplication_Finance.class);
	
	@Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build();
    }

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication_Finance.class, args);
		log.info("Employee Finance Serice has Started.");
	}

}
