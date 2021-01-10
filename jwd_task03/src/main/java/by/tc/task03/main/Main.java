package by.tc.task03.main;

import by.tc.task03.entity.impl.Node;
import by.tc.task03.service.XMLParserService;
import by.tc.task03.service.impl.XMLParserServiceImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        XMLParserService service = new XMLParserServiceImpl();
        try {
            Node rootNode = service.getRootNode("src/main/resources/input.xml");
            NodePrinter.print(rootNode);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
