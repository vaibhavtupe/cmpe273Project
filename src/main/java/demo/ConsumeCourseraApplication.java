package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import resources.Categories;
import resources.Course;
import resources.Element;
import resources.Linked;

@SpringBootApplication
public class ConsumeCourseraApplication {

    public static void main(String[] args) {
        
    	//SpringApplication.run(ConsumeCourseraApplication.class, args);
    	CourseraOperations.getCourseraData("java");
    	
    	
    }
}
