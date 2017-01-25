package org.salesforce.util;

import java.util.HashMap;

public class Cache {

	private static HashMap map = new HashMap();
	
	public Cache(){
		super();
	}
	
	public static void add(String key, String value){
		map.put(key,value);
	}
	
	public static HashMap getMap(){
		return map;
	}
}
