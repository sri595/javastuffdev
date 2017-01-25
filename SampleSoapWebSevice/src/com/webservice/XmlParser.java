package com.webservice;

import java.io.*;
import java.sql.*;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.*;

public class XmlParser {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/WebNmsDB",
							"postgres", "");
			Statement st = con.createStatement();
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			String xml=getInventoryList("inventory");
			InputSource is = new InputSource(new StringReader(xml));
			Document doc = docBuilder
					.parse(is);
			doc.getDocumentElement().normalize();
			System.out.println("Root element of the doc is "
					+ doc.getDocumentElement().getNodeName());
			NodeList listOfPersons = doc.getElementsByTagName("summary");
			for (int s = 0; s < listOfPersons.getLength(); s++) {
				Node firstPersonNode = listOfPersons.item(s);
				if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE) {
					Element firstPersonElement = (Element) firstPersonNode;

					String id=firstPersonElement.getAttribute("id");
					
					
					
					NodeList nameList = firstPersonElement
							.getElementsByTagName("ciscoIdentityCapable");
					Element nameElement = (Element) nameList.item(0);

					NodeList textFNList = nameElement.getChildNodes();
					String name = ((Node) textFNList.item(0)).getNodeValue()
							.trim();

					NodeList addressList = firstPersonElement
							.getElementsByTagName("contact");
					Element addressElement = (Element) addressList.item(0);

					NodeList textLNList = addressElement.getChildNodes();
					String address = ((Node) textLNList.item(0)).getNodeValue()
							.trim();

					NodeList deviceIdList = firstPersonElement
							.getElementsByTagName("deviceId");
					Element deviceElement = (Element) deviceIdList.item(0);

					NodeList textTNList = deviceElement.getChildNodes();
					String deviceid = ((Node) textTNList.item(0))
							.getNodeValue().trim();

					NodeList deviceNameList = firstPersonElement
							.getElementsByTagName("deviceName");
					Element deviceNameElement = (Element) deviceNameList
							.item(0);

					NodeList textFONList = deviceNameElement.getChildNodes();
					String devicename = ((Node) textFONList.item(0))
							.getNodeValue().trim();

					NodeList deviceTypeList = firstPersonElement
							.getElementsByTagName("deviceType");
					Element deviceTypeElement = (Element) deviceTypeList
							.item(0);

					NodeList textFINList = deviceTypeElement.getChildNodes();
					String deviceType = ((Node) textFINList.item(0))
							.getNodeValue().trim();

					NodeList ipAddressList = firstPersonElement
							.getElementsByTagName("ipAddress");
					Element ipAddressElement = (Element) ipAddressList.item(0);

					NodeList textSINList = ipAddressElement.getChildNodes();
					String ipAddress = ((Node) textSINList.item(0))
							.getNodeValue().trim();

					NodeList locationList = firstPersonElement
							.getElementsByTagName("location");
					Element locationElement = (Element) locationList.item(0);

					NodeList textSENList = locationElement.getChildNodes();
					String location = ((Node) textSENList.item(0))
							.getNodeValue().trim();

					NodeList locationCapableList = firstPersonElement
							.getElementsByTagName("locationCapable");
					Element locationCapableElement = (Element) locationCapableList
							.item(0);

					NodeList textEINList = locationCapableElement
							.getChildNodes();
					String locationCapable = ((Node) textEINList.item(0))
							.getNodeValue().trim();

					NodeList nrPortsDownList = firstPersonElement
							.getElementsByTagName("nrPortsDown");
					Element nrPortsDownElement = (Element) nrPortsDownList
							.item(0);

					NodeList textNINList = nrPortsDownElement.getChildNodes();
					String nrPortsDown = ((Node) textNINList.item(0))
							.getNodeValue().trim();

					NodeList nrPortsUpList = firstPersonElement
							.getElementsByTagName("nrPortsUp");
					Element nrPortsUpElement = (Element) nrPortsUpList.item(0);

					NodeList textTENList = nrPortsUpElement.getChildNodes();
					String nrPortsUp = ((Node) textTENList.item(0))
							.getNodeValue().trim();

					NodeList productFamilyList = firstPersonElement
							.getElementsByTagName("productFamily");
					Element productFamilyElement = (Element) productFamilyList
							.item(0);

					NodeList textELNList = productFamilyElement.getChildNodes();
					String productFamily = ((Node) textELNList.item(0))
							.getNodeValue().trim();

					NodeList reachabilityList = firstPersonElement
							.getElementsByTagName("reachability");
					Element reachabilityElement = (Element) reachabilityList
							.item(0);

					NodeList textTWNList = reachabilityElement.getChildNodes();
					String reachability = ((Node) textTWNList.item(0))
							.getNodeValue().trim();

					NodeList softwareVersionList = firstPersonElement
							.getElementsByTagName("softwareVersion");
					Element softwareVersionElement = (Element) softwareVersionList
							.item(0);

					NodeList textTHINList = softwareVersionElement
							.getChildNodes();
					String softwareVersion = ((Node) textTHINList.item(0))
							.getNodeValue().trim();

					NodeList systemTimeList = firstPersonElement
							.getElementsByTagName("systemTime");
					Element systemTimeElement = (Element) systemTimeList
							.item(0);

					NodeList textFOUINList = systemTimeElement.getChildNodes();
					String systemTime = ((Node) textFOUINList.item(0))
							.getNodeValue().trim();
					
					NodeList upTimeList = firstPersonElement
							.getElementsByTagName("upTime");
					Element upTimeElement = (Element) upTimeList
							.item(0);

					NodeList textFIFINList = upTimeElement.getChildNodes();
					String upTime = ((Node) textFIFINList.item(0))
							.getNodeValue().trim();


					/*
					 * int i = st
					 * .executeUpdate("insert into user(name,address) values('"
					 * + name + "','" + address + "')");
					 */
					System.out.println(id+"......."+name + "......." + address + "....."
							+ deviceid + "......" + devicename + "........."
							+ deviceType + "......" + ipAddress + "......."
							+ location + "........" + locationCapable
							+ "......." + nrPortsDown + "........" + nrPortsUp
							+ "......" + productFamily + "......"
							+ reachability + "........" + softwareVersion
							+ "......" + systemTime+"....."+upTime);
				}
			}
			System.out.println("Data is successfully inserted!");
		} catch (Exception err) {
			System.out.println(" " + err.getMessage());
		}
	}
	
	public static String getInventoryList(String name) {
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
					//System.out.println(strLine);
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