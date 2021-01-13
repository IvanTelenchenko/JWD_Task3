package by.epam.maven.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.maven.entity.Node;
import by.epam.maven.entity.criteria.TypeOfTag;

public class ParserXML {

	public Node parser(List<String> list) {

		Node node = new Node();

		LinkedList<Node> buffer = new LinkedList<Node>();

		Iterator<String> iterator = list.iterator();
		ListIterator<Node> listIter = buffer.listIterator();

		while (iterator.hasNext()) {

			String line = iterator.next();

			if (Pattern.compile(TypeOfTag.OPENTAG).matcher(line).find() 
					&& !Pattern.compile(TypeOfTag.COMMENTTAG).matcher(line).find() 
					&& !Pattern.compile(TypeOfTag.INFOTAG).matcher(line).find()) {
				
				Node newNode = new Node();
				newNode.setName(getNameOfOpeningTagOfNode(line));

				if (isHasContetn(line)) {
					newNode.setContent(getContetnFromNode(line));
				}

				if (Pattern.compile(TypeOfTag.ATTRIBUTES).matcher(line).find()) {
					newNode.addAttribute(getAttributeFromNode(line));
				}

				buffer.add(newNode);
			}

			if (Pattern.compile(TypeOfTag.CLOSETAG).matcher(line).find()) {

				if (buffer.size() > 2) {
					listIter = buffer.listIterator(buffer.size() - 1);
					listIter.previous().addChild(buffer.pollLast());

				} else if (buffer.size() == 2) {
					buffer.peekFirst().addChild(buffer.pollLast());
				}
			}
		}
		node = buffer.getFirst();
		
		return node;
	}

	public static String getNameOfOpeningTagOfNode(String line) {

		String name = null;

		Pattern pattern = Pattern.compile(TypeOfTag.OPENTAG);
		Matcher matcher = pattern.matcher(line);
		if (matcher.find()) {
			name = matcher.group();
		}

		name = name.replaceAll("[<>]", "");

		return name;
	}

	public static List<String> getAttributeFromNode(String line) {

		List<String> listName = new ArrayList<String>();
		String name = null;

		Pattern pattern = Pattern.compile(TypeOfTag.ATTRIBUTES);
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			name = matcher.group();
			name = name.replaceAll("[\"\']", "");
			listName.add(name);
		}

		return listName;

	}

	public static boolean isHasContetn(String line) {
		
		Pattern pattern = Pattern.compile(TypeOfTag.CONTENT);
		Matcher matcher = pattern.matcher(line);

		if (matcher.find()) {
			return true;
		}

		return false;
	}

	public static String getContetnFromNode(String line) {

		String name = null;

		Pattern pattern = Pattern.compile(TypeOfTag.CONTENT);
		Matcher matcher = pattern.matcher(line);
		
		if (matcher.find()) {
			name = matcher.group();
		}
		
		name = name.replaceAll("[<>]", "");

		return name;
	}
}