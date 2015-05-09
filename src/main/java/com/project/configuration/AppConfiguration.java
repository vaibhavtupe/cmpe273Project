package com.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.project.implementation.CourseraOperations;


@Configuration
@EnableTransactionManagement
public class AppConfiguration {
	
	@Bean
	public CourseraOperations getCourseraOp(){
		
		return new CourseraOperations();
	}

}
