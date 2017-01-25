package org.salesforce.test;

import java.io.File;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;
import org.salesforce.oauth.integration.IdServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestJSON {
	private static final Logger LOG = LoggerFactory
			.getLogger(TestJSON.class);
	public static void main(String[] args){

		
		try {
			File f = new File("/home/infra3/Temp/test.json");
			JSONObject jsonResponse = new JSONObject(new JSONTokener(new FileReader(f)));
			System.out.println(jsonResponse.getJSONObject("urls"));
			System.out.println(jsonResponse.get("organization_id"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
