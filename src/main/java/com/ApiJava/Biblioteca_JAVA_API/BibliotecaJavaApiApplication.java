package com.ApiJava.Biblioteca_JAVA_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class BibliotecaJavaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaJavaApiApplication.class, args);
	}

}
