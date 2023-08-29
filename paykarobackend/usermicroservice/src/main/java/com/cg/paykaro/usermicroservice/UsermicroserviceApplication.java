package com.cg.paykaro.usermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class UsermicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermicroserviceApplication.class, args);
	}
	
//
//	@Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.basePackage("	com.cg.paykaro.usermicroservice")).build();
//    }
	
}
