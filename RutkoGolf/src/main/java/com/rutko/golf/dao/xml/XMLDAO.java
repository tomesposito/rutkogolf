package com.rutko.golf.dao.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLDAO {
private Logger log = Logger.getLogger(XMLDAO.class) ; 
	
	//initialize variable (volatile for synchronization)
	private volatile Document doc = null ;
	private String filepath ;
	
	//method that loads the xml - synchronized for concurrency
	private synchronized void loadXMLConfig(){
		File file = new File(filepath);
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			doc = builder.parse(file);
		}catch (IOException e){
			log.error(e) ;
		}catch (ParserConfigurationException e){
			log.error(e) ;
		}catch (SAXException e){
			log.error(e) ;
		}
	}
	
	/**
	 * Aug 26, 2010
	 * 
	 * @author ESPOTW
	 *
	 * This method returns a Page object created from the xml by folder and title
	 *
	 * @param folder
	 * @param title
	 * @return Page
	 */
	public String retrievePageByTitle(String title){
		this.loadXMLConfig() ;
		
		NodeList pgs = doc.getElementsByTagName(title) ;
		
		for(int i=0; i<pgs.getLength(); i++){
			Element pg = (Element) pgs.item(i) ;
			return this.getTextContent(pg, "content") ;
		}
		return "error" ;
	}
	
	private String getTextContent(Element element, String name){
		NodeList list = element.getElementsByTagName(name) ;
		Element line = (Element) list.item(0) ;
		//if not all links have an other field attached
		if(line != null){
			return line.getFirstChild().getNodeValue() ;
		}
		return null ;
	}
	
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

}
