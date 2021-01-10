package by.tc.task03.patterns;

public interface XMLPatterns {
    String OPEN_TAG = "<[^/>]+>";
    String CLOSE_TAG = "</[^>]+>";
    String CONTENT = "[^<>]+";
    String COMMENT = "<!--.*-->";
    String XML_DECLARATION = "<\\?.*\\?>";
    String ATTRIBUTE = "[\\s<>=\"]+";
    String OPEN_TAG_AND_CONTENT = OPEN_TAG + CONTENT;
    String OPEN_TAG_CONTENT_CLOSE_TAG = OPEN_TAG_AND_CONTENT + CLOSE_TAG;
    String CONTENT_AND_CLOSE_TAG = CONTENT + CLOSE_TAG;
}
