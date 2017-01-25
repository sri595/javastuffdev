package org.salesforce.util;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLUtil {

	public XMLUtil() {
		super();
	}

	public static void main(String[] args) {
		String[] test = new String[2];
		test[0] = "Hello1";
		test[1] = "Hello2";
		createDeployXMLFile(test);
		// System.out.println("path - " +getCurrentPath());
	}

	private static String getCurrentPath() {
		try {
			File currentDirectory = new File(new File(".").getAbsolutePath());
			return currentDirectory.getAbsolutePath();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void createDeployXMLFile(String[] objects) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();

			Element rootElement = doc.createElementNS(
					"http://soap.sforce.com/2006/04/metadata", "Package");
			doc.appendChild(rootElement);

			// staff elements
			Element types = doc.createElement("types");
			rootElement.appendChild(types);

			// firstname elements
			Element members = null;
			if (objects == null) {
				members = doc.createElement("members");
				members.appendChild(doc.createTextNode("*"));
				types.appendChild(members);
			}
			else if(objects.length>0){
				for (int i = 0; i < objects.length; i++) {
					String s = objects[i];
					members = doc.createElement("members");
					members.appendChild(doc.createTextNode(s));
					types.appendChild(members);
				}
			}
			// lastname elements
			Element name = doc.createElement("name");
			name.appendChild(doc.createTextNode("CustomObject"));
			types.appendChild(name);

			Element version = doc.createElement("version");
			version.appendChild(doc.createTextNode("33.0"));
			rootElement.appendChild(version);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("package.xml"));
			transformer.transform(source, result);
			System.out.println("File saved!");
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (Exception tfe) {
			tfe.printStackTrace();
		}
	}

	private static void prepareDir() {
		try {
			boolean f = new File("package/objects").mkdirs();
		} catch (Exception tfe) {
			tfe.printStackTrace();
		}
	}

	private static String getPackageFilePath() {
		try {
			prepareDir();
			String filePath = (new File("")).getCanonicalPath() + "/"
					+ "package";
			return filePath;
		} catch (Exception tfe) {
			tfe.printStackTrace();
		}
		return "";
	}
}
