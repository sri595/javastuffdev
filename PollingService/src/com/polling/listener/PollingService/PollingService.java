package com.polling.listener.PollingService;

import java.util.TimerTask;

public class PollingService extends TimerTask {
	
	@Override
	public void run() {
		
		ConnectionTest.getData();
		
	}

}
