package com.polling.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.polling.listener.PollingService.Task1;

@WebListener
public class Listener  implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//Timer timer=new Timer();
		//timer.scheduleAtFixedRate(new PollingService(), 0, 10*1000);
		Task1 task1=new Task1();
		Thread t=new Thread(task1);
		t.start();
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
