package by.tc.task03.dao.formatter;

import by.tc.task03.patterns.XMLPatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLStringSplitter {
    private static final String REGEX_FOR_SPLITTING_XML_STRING = "[<>]+";

    public List<String> formattedContentOfXMLString(String xmlString) {
        List<String> formattedContentOfString = new ArrayList<>();
        Matcher openTagAndContent = Pattern.compile(XMLPatterns.OPEN_TAG_AND_CONTENT).matcher(xmlString);
        Matcher openTagContentCloseTag = Pattern.compile(XMLPatterns.OPEN_TAG_CONTENT_CLOSE_TAG).matcher(xmlString);
        Matcher contentAndCloseTag = Pattern.compile(XMLPatterns.CONTENT_AND_CLOSE_TAG).matcher(xmlString);
        Matcher comment = Pattern.compile(XMLPatterns.COMMENT).matcher(xmlString);
        Matcher xmlDeclaration = Pattern.compile(XMLPatterns.XML_DECLARATION).matcher(xmlString);
        String[] tagNameAndContent = xmlString.split(REGEX_FOR_SPLITTING_XML_STRING);
        List<String> tagNameAndContentAsList = new ArrayList<>(Arrays.asList(tagNameAndContent));
        tagNameAndContentAsList.remove("");
        if (openTagAndContent.matches()) {
            formattedContentOfString.add("<" + tagNameAndContentAsList.get(0).trim() + ">");
            formattedContentOfString.add(tagNameAndContentAsList.get(1).trim());
        } else if (openTagContentCloseTag.matches()) {
            formattedContentOfString.add("<" + tagNameAndContentAsList.get(0).trim() + ">");
            formattedContentOfString.add(tagNameAndContentAsList.get(1).trim());
            formattedContentOfString.add("<" + tagNameAndContentAsList.get(2).trim() + ">");
        } else if (contentAndCloseTag.matches()) {
            formattedContentOfString.add(tagNameAndContentAsList.get(0).trim());
            formattedContentOfString.add("<" + tagNameAndContentAsList.get(1).trim() + ">");
        } else if (comment.matches() || xmlDeclaration.matches()) {
        } else {
            formattedContentOfString.add(xmlString);
        }
        return formattedContentOfString;
    }

}
