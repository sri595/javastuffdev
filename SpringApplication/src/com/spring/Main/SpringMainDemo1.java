package com.spring.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.Student;

public class SpringMainDemo1 {
	
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student=(Student)applicationContext.getBean("studentbean");
		System.out.println("Using Application Context");
		student.displayInfo();
		
	}


}
