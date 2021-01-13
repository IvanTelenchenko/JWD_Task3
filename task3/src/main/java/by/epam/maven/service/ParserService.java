package by.epam.maven.service;

import java.io.File;

import by.epam.maven.entity.Node;

public interface ParserService {
	
	Node parserXML(File file);
		
}