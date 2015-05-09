package com.project.controller;

import java.util.List;

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
import com.project.dto.CourseInfoBySkill;
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
	public ResponseEntity<List<CourseInfoBySkill>> getCourseByLinkedIn(@PathVariable String skill){
		
		//String skill="java";
		List<CourseInfoBySkill> courses=cop.getCoursesBySkills(skill);
	
		return new ResponseEntity<List<CourseInfoBySkill>>(courses, HttpStatus.OK);
		
	}

}
