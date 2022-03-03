package com.ManyToMany.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="API Clientes",version="1.0",description="Crud completo de clientes"))

public class ApiRestManyToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestManyToManyApplication.class, args);
	}

}
