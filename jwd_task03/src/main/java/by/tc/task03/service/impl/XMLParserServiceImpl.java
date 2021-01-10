package by.tc.task03.service.impl;

import by.tc.task03.dao.Parser;
import by.tc.task03.dao.impl.ParserImpl;
import by.tc.task03.dao.reader.XmlFileReader;
import by.tc.task03.entity.impl.Node;
import by.tc.task03.service.XMLParserService;

import java.io.IOException;

public class XMLParserServiceImpl implements XMLParserService {
    @Override
    public Node getRootNode(String filePath) throws IOException {
        Parser xmlParser = new ParserImpl(new XmlFileReader(filePath));
        Node rootNode = xmlParser.getRootElement();
        return rootNode;
    }
}
