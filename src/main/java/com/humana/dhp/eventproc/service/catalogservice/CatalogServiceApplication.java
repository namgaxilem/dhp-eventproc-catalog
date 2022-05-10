package com.humana.dhp.eventproc.service.catalogservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class CatalogServiceApplication implements WebMvcConfigurer {

	@Value("${server.cors.pathMapping}")
	private String pathMapping;

	@Value("${server.cors.allowedOrigins}")
	private List<String> allowedOrigins;

	@Value("${server.cors.allowedMethods}")
	private List<String> allowedMethods;

	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping(pathMapping)
				.allowedOrigins(allowedOrigins.toArray(new String[allowedOrigins.size()]))
				.allowedMethods(allowedMethods.toArray(new String[allowedMethods.size()]));
	}
}
