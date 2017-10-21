package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

@SpringBootApplication
public class DemoApplication {
	private final Logger logger= LoggerFactory.getLogger(DemoApplication.class);

	public DemoApplication() {
		String configFilePath  = System.getProperty("user.dir") + "\\ext\\conf\\demoConf.xml";
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File file = new File(configFilePath);
			Document doc = builder.parse(file);
			Element root = doc.getDocumentElement();
			Node node;
			node = root.getElementsByTagName("key").item(0);
			String value = node.getAttributes().getNamedItem("value").getNodeValue();

		} catch (Exception e) {
			logger.error("读取自身配置文件错误",e);
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
