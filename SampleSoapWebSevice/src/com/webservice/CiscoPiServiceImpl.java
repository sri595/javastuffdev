package com.webservice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.jws.WebService;

///Service Implementation
@WebService(endpointInterface = "com.webservice.CiscoPIServices")
public class CiscoPiServiceImpl implements CiscoPIServices {

	@Override
	public String getInventoryList(String name) {
		String strLine = "";
		StringBuffer sb=new StringBuffer();
		if (name.equalsIgnoreCase("Inventory")) {
			BufferedReader br = null;

			try {
				br = new BufferedReader(
						new FileReader(
								"/home/srikanth/webnmsworkspace/SampleSoapWebSevice/inventory.xml"));
				while ((strLine = br.readLine()) != null) {
					sb.append(strLine);
					System.out.println(strLine);
				}
				br.close();
			} catch (FileNotFoundException e) {
				System.err.println("Unable to find the file: fileName");
			} catch (IOException e) {
				System.err.println("Unable to read the file: fileName");
			}

		}
		return sb.toString();

	}

}
