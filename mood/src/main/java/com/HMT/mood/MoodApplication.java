package com.HMT.mood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.HMT.mood.controller.MainController;

@SpringBootApplication
@ComponentScan(basePackageClasses = MainController.class)
public class MoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoodApplication.class, args);
	}

}
