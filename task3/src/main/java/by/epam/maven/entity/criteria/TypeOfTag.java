package by.epam.maven.entity.criteria;

public final class TypeOfTag {
	
	public static final String OPENTAG = "<[^/].+?>";
	public static final String CLOSETAG = "</.+>$";
	public static final String ATTRIBUTES = "[\"\'].+?[\"\']";
	public static final String COMMENTTAG = "<!--(.+)?-->";
	public static final String INFOTAG = "<(\\?xml).+?(\\?)>";
	public static final String CONTENT = ">.+<";
	
	private TypeOfTag() {
		
	}
}