package by.epam.maven.service.imp;

import java.io.File;

import by.epam.maven.entity.Node;
import by.epam.maven.parser.ParserXML;
import by.epam.maven.reader.ReaderXML;
import by.epam.maven.service.ParserService;

public class ParserServiceImp implements ParserService{
	
	@Override
	public Node parserXML(File file) {
		
		ReaderXML reader = new ReaderXML();
		ParserXML parser = new ParserXML();
		
		Node node = new Node();
		
		node = parser.parser(reader.readFileInList(file));
		
		return node;
	}
}