package com.polling.listener.PollingService;

public class Task1 implements Runnable {
	
	@Override
	public void run() {
		 final long timeInterval = 5000;
		while (true) {
		      // ------- code for task to run
			 ConnectionTest.getData();
		      // ------- ends here
		      try {
		       Thread.sleep(timeInterval);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		
		
	}


	}}



