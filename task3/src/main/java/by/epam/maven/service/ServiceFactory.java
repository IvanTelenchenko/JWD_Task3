package by.epam.maven.service;

import by.epam.maven.service.imp.ParserServiceImp;

public class ServiceFactory {
	
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final ParserService parserService = new ParserServiceImp();
	
	private ServiceFactory() {
	}
	
	public static ServiceFactory getInstance() {
		return instance;
	}
	
	public ParserService getParserSevice() {
		return parserService;
	}
}
