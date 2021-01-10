package by.tc.task03.dao.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XmlFileReader {
    private String xmlFilePath;
    private FileReader fileReader;
    private List<String> xmlFileContentAsList;

    public XmlFileReader(String xmlFilePath) {
        xmlFileContentAsList = new ArrayList<>();
        this.xmlFilePath = xmlFilePath;
    }

    public void readAll() throws IOException {
        StringBuilder result = new StringBuilder();
        fileReader = new FileReader(new File(xmlFilePath));
        BufferedReader xmlBufferedReader = new BufferedReader(fileReader);
        String currentLine = xmlBufferedReader.readLine();
        while (currentLine != null) {
            if ("".matches(currentLine) || currentLine.matches("[\\s]+")) {
                currentLine = xmlBufferedReader.readLine();
                continue;
            }
            currentLine = currentLine.trim();
            result.append(currentLine);
            xmlFileContentAsList.add(currentLine);
            currentLine = xmlBufferedReader.readLine();
        }
    }


    public List<String> getXmlFileContentAsList() {
        this.editList();
        return xmlFileContentAsList;
    }

    private void editList() {
        String expressionForSplittingTags = "> +<|><";
        String replacementForSplittingTags = ">,<";
        List<String> listOfFormattedXMLFileLines = new ArrayList<>();
        for (String currentLine : xmlFileContentAsList) {
            currentLine = currentLine.replaceAll(expressionForSplittingTags, replacementForSplittingTags);
            String[] currentLineParts = currentLine.split(",");
            listOfFormattedXMLFileLines.addAll(Arrays.asList(currentLineParts));
        }
        xmlFileContentAsList = listOfFormattedXMLFileLines;
    }
}
