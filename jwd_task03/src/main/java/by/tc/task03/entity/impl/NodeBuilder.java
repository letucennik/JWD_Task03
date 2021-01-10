package by.tc.task03.entity.impl;

import by.tc.task03.patterns.XMLPatterns;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NodeBuilder {
    private Node node;

    public NodeBuilder(Node node) {
        this.node = node;
    }

    public void buildNode(String tagNameAndAttributes) {
        String[] parameters = tagNameAndAttributes.split(XMLPatterns.ATTRIBUTE);
        List<String> filteredContentOfCurrentString = new ArrayList<>(Arrays.asList(parameters));
        filteredContentOfCurrentString.remove("");
        node.setName(filteredContentOfCurrentString.get(0));
        filteredContentOfCurrentString.remove(0);
        node.setAttributes(createListOfAttributes(filteredContentOfCurrentString));
    }

    private List<Attribute> createListOfAttributes(List<String> filteredContentOfXMLString) {
        List<Attribute> listOfAttributes = new ArrayList<>();
        Attribute currentAttribute;
        for (int i = 0; i < filteredContentOfXMLString.size() - 1; i += 2) {
            currentAttribute = new Attribute();
            currentAttribute.setNameAndValue(new Pair<>(filteredContentOfXMLString.get(i), filteredContentOfXMLString.get(i + 1)));
            listOfAttributes.add(currentAttribute);
        }
        return listOfAttributes;
    }
}
