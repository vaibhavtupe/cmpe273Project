package com.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.project.configuration.AppConfiguration;
import com.project.dto.Element;
import com.project.implementation.CourseraOperations;




@RestController
@EnableAutoConfiguration
@ComponentScan
@RequestMapping("/api/v1/*")
@Import(AppConfiguration.class)
public class AppController extends WebMvcConfigurerAdapter {
	
	@Autowired
	CourseraOperations cop;
	
	@RequestMapping(value="/getcoursesbyslinkedinskill/{skill}", method=RequestMethod.GET)
	public ResponseEntity<Element> getCourseByLinkedIn(@PathVariable String skill){
		
		//String skill="java";
		Element element=cop.getCoursesBySkills(skill);
	
	
		return new ResponseEntity<Element>(element, HttpStatus.OK);
		
	}

}
