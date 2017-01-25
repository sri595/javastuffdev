package org.salesforce.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class TokenRepoUtil {

	private static File file = new File("tokens.xml");
	private static Properties properties = new Properties();
	private static FileOutputStream fileOut = null;
	private static TokenRepoUtil tokenRepoUtil;
	FileInputStream fileInput = null;

	private TokenRepoUtil() {
		super();
		try {
			fileOut = new FileOutputStream(file);
			fileInput = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static TokenRepoUtil getInstance() {
		if (tokenRepoUtil == null) {
			tokenRepoUtil = new TokenRepoUtil();
		}
		return tokenRepoUtil;
	}

	public static void storeKeyToken(String key, String value) {
		try {
			properties.setProperty(key, value);
			FileOutputStream fileOut = new FileOutputStream(file);
			properties.storeToXML(fileOut, "Tokens");
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getToken(String key) {
		String value = "";
		try {
			Enumeration enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String localKey = (String) enuKeys.nextElement();
				if (localKey.equals("key")) {
					value = properties.getProperty(key);
					System.out.println(key + ": " + value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void listTokens() {
		try {
			Enumeration enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				System.out.println(key + ": " + value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
