package demo;

import org.springframework.web.client.RestTemplate;

import resources.Categories;
import resources.Course;
import resources.Element;

public class CourseraOperations {
	
	public static Element elements;
	
	
	
	// takes search query skill set
	
	public static void getCourseraData(String skill){
		
		RestTemplate restTemplate = new RestTemplate();
		
	    String url="https://api.coursera.org/api/catalog.v1/courses?q=search&query="+skill+"&includes=sessions,instructors,categories,universities&fields=photo,instructor";
    	elements = restTemplate.getForObject(url, Element.class);

    	 System.out.println(elements.getElements());
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
    		 
    		 
    	 }
    	
	}
	
//	public static void getCategoryData(){
//		
//		String categoryUrl="https://api.coursera.org/api/catalog.v1/categories/";
//		RestTemplate restTemplate = new RestTemplate();
//		 Categories ca[]=elements.getLinked().getCategories();
//		 for(int i=0;i<ca.length;i++){
//		  
//			 Categories c = restTemplate.getForObject(categoryUrl+ca[i].getId()+"?fields=description", Categories.class);
//			 ca[i].setDescription(c.getDescription());
//			 System.out.println("---tupe-- : "+c.toString());
//			 System.out.println("Category ID : "+ca[i].getId());
//			 System.out.println("Category short name : "+ca[i].getShortName());
//			 System.out.println("Category Name : "+ca[i].getName());
//			 System.out.println("Category Description : "+ca[i].getDescription());
//			 
//		 }
//		
		
		
		
//	}

}
