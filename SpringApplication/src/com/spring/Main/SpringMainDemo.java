package com.spring.Main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.spring.beans.Student;

public class SpringMainDemo {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		Student student = (Student) factory.getBean("studentbean");
		Student student1 = (Student) factory.getBean("studentbean");
		System.out.println(student.toString());
		System.out.println(student1.toString());


		student.displayInfo();

	}

}
