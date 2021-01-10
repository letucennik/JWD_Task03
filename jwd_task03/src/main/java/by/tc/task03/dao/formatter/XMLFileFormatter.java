package by.tc.task03.dao.formatter;

import by.tc.task03.dao.reader.XmlFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class XMLFileFormatter {
    private XmlFileReader xmlFileReader;

    public XMLFileFormatter(XmlFileReader reader) {
        xmlFileReader = reader;
    }

    public List<String> listOfFormattedXMLFileLines() throws IOException {
        xmlFileReader.readAll();
        List<String> listOfFormattedLines = new ArrayList<>();
        List<String> listOfXMLFileLines = xmlFileReader.getXmlFileContentAsList();
        List<String> formattedContentOfCurrentXMLString;
        XMLStringSplitter xmlStringSplitter = new XMLStringSplitter();
        for (String currentLine : listOfXMLFileLines) {
            formattedContentOfCurrentXMLString = xmlStringSplitter.formattedContentOfXMLString(currentLine);
            listOfFormattedLines.addAll(formattedContentOfCurrentXMLString);
        }
        return listOfFormattedLines;
    }

}
