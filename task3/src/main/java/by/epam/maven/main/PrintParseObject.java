package by.epam.maven.main;

import java.util.List;

import by.epam.maven.entity.Attribute;
import by.epam.maven.entity.Node;

public class PrintParseObject {

	public static void print(Node node) {

		String print = getStringToPrint(node).toString();

		System.out.println(print);

	}

	public static StringBuilder getStringToPrint(Node node) {

		StringBuilder print = new StringBuilder();

		print.append(printAttribute(node.getAttribute())).append(printContent(node.getContent()))
				.append(printList(node.getListNode()));

		return print;
	}

	public static String printList(List<Node> listNode) {

		String list = "";

		if (listNode == null) {

			list = " ";

		} else {

			for (Node node : listNode) {
				list += getStringToPrint(node);
			}

			list += "\n";
		}
		return list;
	}

	public static String printContent(String content) {

		String line = content == null ? "" : content;

		return line;
	}

	public static String printAttribute(List<Attribute> attribute) {

		String line = "";

		if (attribute == null) {

			line = "";

		} else {

			for (Attribute att : attribute) {
				line += att.getContent() + ". ";
			}
		}

		return line;
	}
}