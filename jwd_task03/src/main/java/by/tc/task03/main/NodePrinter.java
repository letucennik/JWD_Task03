package by.tc.task03.main;

import by.tc.task03.entity.impl.Node;

import java.util.List;

public class NodePrinter {
    private static int indent = 1;
    private static int ADD = 4;

    public static void print(Node rootNode) {
        if (rootNode.hasChildNodes()) {
            System.out.printf("%" + indent + "c%s%s", ' ', "<", rootNode.toString());
            indent += ADD;
            System.out.println(">");
            List<Node> childNodes = rootNode.getChildNodes();
            childNodes.forEach(NodePrinter::print);
            indent -= ADD;
            System.out.printf("%" + indent + "c</%s>\n", ' ', rootNode.getName());
        } else {
            System.out.printf("%" + indent + "c%s\n", ' ', rootNode.getContent());
        }
    }
}