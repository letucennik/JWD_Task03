package by.tc.task03.dao.impl;

import by.tc.task03.dao.Parser;
import by.tc.task03.dao.formatter.XMLFileFormatter;
import by.tc.task03.dao.reader.XmlFileReader;
import by.tc.task03.entity.impl.Node;
import by.tc.task03.entity.impl.NodeBuilder;
import by.tc.task03.patterns.XMLPatterns;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

public class ParserImpl implements Parser {
    private XmlFileReader xmlFileReader;

    public ParserImpl(XmlFileReader xmlFileReader) {
        this.xmlFileReader = xmlFileReader;
    }


    @Override
    public Node getRootElement() throws IOException {
        XMLFileFormatter xmlStringFormatter = new XMLFileFormatter(xmlFileReader);
        List<String> listOfFormattedXMLFileLines = xmlStringFormatter.listOfFormattedXMLFileLines();
        NodeBuilder nodeBuilder;
        Node currentNode;
        Node peekOfStack = null;
        Stack<Node> stackOfNodes = new Stack<>();
        for (String currentLine : listOfFormattedXMLFileLines) {
            if (!stackOfNodes.isEmpty()) {
                peekOfStack = stackOfNodes.peek();
            }
            currentNode = new Node();
            nodeBuilder = new NodeBuilder(currentNode);
            if (currentLine.matches(XMLPatterns.OPEN_TAG)) {
                nodeBuilder.buildNode(currentLine);
                stackOfNodes.push(currentNode);
            } else if (currentLine.matches(XMLPatterns.CLOSE_TAG)) {
                currentNode = stackOfNodes.pop();
                if (stackOfNodes.isEmpty()) {
                    break;
                } else {
                    stackOfNodes.peek().addToChildNodes(currentNode);
                }
            } else {
                stackOfNodes.peek().addToContent(currentLine);
            }

        }

        return peekOfStack;
    }


}
