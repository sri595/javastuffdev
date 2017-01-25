package com.spring.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.Question;

public class SpringMainDemo4 {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextDI.xml");
		Question question = (Question) applicationContext.getBean("q1");
		System.out.println("Using Application Context");
		question.displayInfo();

	}

}
