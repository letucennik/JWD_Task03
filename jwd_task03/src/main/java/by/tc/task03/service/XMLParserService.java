package by.tc.task03.service;

import by.tc.task03.entity.impl.Node;

import java.io.IOException;

public interface XMLParserService {
    Node getRootNode(String filePath) throws IOException;
}
