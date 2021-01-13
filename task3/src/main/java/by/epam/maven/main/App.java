package by.epam.maven.main;

import java.io.File;

import by.epam.maven.entity.Node;
import by.epam.maven.service.ParserService;
import by.epam.maven.service.ServiceFactory;

public class App {
    public static void main( String[] args ){
    	
    	Node node = new Node();
    	File file = new File("resources\\1.xml");

    	
    	ServiceFactory factory = ServiceFactory.getInstance();
    	ParserService service = factory.getParserSevice();
    	
    	node = service.parserXML(file);
    	
    	PrintParseObject.print(node);

    }
}