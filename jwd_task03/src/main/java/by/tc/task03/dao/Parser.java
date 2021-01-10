package by.tc.task03.dao;

import by.tc.task03.entity.impl.Node;

import java.io.IOException;

public interface Parser {
    Node getRootElement() throws IOException;
}
