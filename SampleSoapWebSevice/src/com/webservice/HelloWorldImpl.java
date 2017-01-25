package com.webservice;

import java.util.Date;

import javax.jws.WebService;

///Service Implementation
@WebService(endpointInterface = "com.webservice.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHelloWorldAsString(String name) {

		Date today = new Date();

		String currenTime = today.getHours() + ":" + today.getMinutes() + ":"
				+ today.getSeconds();

		return name + ".....Time is....." + currenTime;
	}

}