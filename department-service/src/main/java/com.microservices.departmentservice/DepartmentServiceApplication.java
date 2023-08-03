package com.microservices.departmentservice;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Rest API design for Department microservice",
				description = " Department microservice REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Ruchir Ajit Shrikhande",
						email = "ruchir.shrikhande555@gmail.com",
						url = "https://github.com/ruchir327"
				)
		)
)
public class DepartmentServiceApplication {
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}


	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
