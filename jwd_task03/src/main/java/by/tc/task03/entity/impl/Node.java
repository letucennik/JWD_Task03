package by.tc.task03.entity.impl;

import by.tc.task03.entity.Element;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node implements Serializable, Element {
    private String name;
    private List<Attribute> attributes;
    private List<Node> childNodes;
    private String content;

    public Node() {
        name = "";
        attributes = new ArrayList<>();
        childNodes = new ArrayList<>();
        content = "";
    }


    public Node(String name, List<Attribute> attributes, List<Node> childNodes, String content) {
        this.name = name;
        this.attributes = attributes;
        this.childNodes = childNodes;
        this.content = content;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public boolean hasChildNodes() {
        return !this.childNodes.isEmpty();
    }

    public boolean hasAttributes() {
        return !this.attributes.isEmpty();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<Node> childNodes) {
        this.childNodes = childNodes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addToContent(String contentPart) {
        this.content += contentPart + " ";
    }

    public void addToChildNodes(Node node) {
        childNodes.add(node);
    }

    public void addToAttributes(Attribute attribute) {
        attributes.add(attribute);
    }

    public String getListOfAttributesAsString() {
        StringBuilder listOfAttributes = new StringBuilder();
        for (Attribute attribute : attributes) {
            listOfAttributes.append(attribute.toString() + "\t");
        }
        return listOfAttributes.toString().trim();
    }

    public String getListOfChildNodesAsString() {
        StringBuilder listOfChildNodes = new StringBuilder();
        for (Node node : childNodes) {
            listOfChildNodes.append("\t" + node.toString() + "\n");
        }
        return listOfChildNodes.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Node node = (Node) obj;
        if (null == this.name) {
            return null == node.name;
        } else if (!name.equals(node.name)) {
            return false;
        }

        if (null == this.content) {
            return null == node.content;
        } else if (!content.equals(node.content)) {
            return false;
        }

        if (null == this.childNodes) {
            return null == node.childNodes;
        } else if (!childNodes.equals(node.childNodes)) {
            return false;
        }

        if (null == this.attributes) {
            return null == node.attributes;
        } else if (!attributes.equals(node.attributes)) {
            return false;
        }
        return true;

    }

    @Override
    public int hashCode() {
        return (name == null ? 0 : name.hashCode()) + (attributes == null ? 0 : attributes.hashCode()) +
                (childNodes == null ? 0 : childNodes.hashCode()) + (content == null ? 0 : content.hashCode());
    }

    @Override
    public String toString() {
        if ("".equals(this.content)) {
            if (this.hasAttributes()) {
                return this.name + " : " + this.getListOfAttributesAsString();
            } else {
                return this.name;
            }

        } else {
            return this.content;
        }
    }
}
