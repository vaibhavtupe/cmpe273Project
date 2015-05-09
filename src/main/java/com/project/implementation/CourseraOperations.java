package com.project.implementation;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.project.dto.Course;
import com.project.dto.Element;


@Component
public class CourseraOperations {





	// takes search query skill set

	public  Element getCoursesBySkills(String skill){

		RestTemplate restTemplate = new RestTemplate();
		Element elements;

		String url="https://api.coursera.org/api/catalog.v1/courses?q=search&query="+skill+"&includes=sessions,instructors,categories,universities&fields=photo,instructor";
		elements = restTemplate.getForObject(url, Element.class);

		/*System.out.println(elements.getElements());
		for(Course c : elements.getElements())
		{

			System.out.println("Course Id : "+c.getId());
			System.out.println("Course Name : "+c.getName());
			System.out.println("Course ShortName : "+c.getShortName());
			System.out.println("Course photo : "+c.getPhoto());
			System.out.println("Course instructor : "+ c.getInstructor());

			// Linked l=c.getLinked();
			//System.out.println("test : "+l.getInstructors());

			// getCategoryData();
			System.out.println("-----------------------------------------------");


		}*/
		
		return elements;

	}


}
