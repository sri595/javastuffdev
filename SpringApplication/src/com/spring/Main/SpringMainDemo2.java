package com.spring.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.Employee;

public class SpringMainDemo2 {
	
public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextDI.xml");
		Employee student=(Employee)applicationContext.getBean("e");
		System.out.println("Using Application Context");
		student.show();
		
	}

}
