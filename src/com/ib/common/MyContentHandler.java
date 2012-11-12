package com.ib.common;

import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class MyContentHandler implements ContentHandler {

    private HashMap<String, Object> math;
    private HashMap<String, Object> questions;
//    private HashMap<String, Object> question;
//    private HashMap<String, Object> answer;

    private String question;
    private String answer;

    @Override
    public void startDocument() throws SAXException {
        /* You can perform some action in this method
         * for example to reset some sort of Collection
         * or any other variable you want. It gets called
         * every time a document starts. */
        math = new HashMap<String, Object>();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes atts) throws SAXException {
        // Gets called every time an opening tag is encountered.
        if(localName.equalsIgnoreCase("math")) {
            /* We've found a "feed" opening tag so we capture its
             * version attribute and put it into our HashMap.*/
//            math.put("Version", atts.getValue("version"));
//        } else if(localName.equalsIgnoreCase("PEROID")) {
//            questions = new HashMap<String, Object>();
//            questions.put("From", atts.getValue("from"));
//            questions.put("to", atts.getValue("to"));
//        } else if(localName.equalsIgnoreCase("LINE")) {
//            linesMap = new HashMap<String, Object>();
//        } else if(localName.equalsIgnoreCase("LINE")) {
//            answer = new HashMap<String, Object>();
//            lineId = atts.getValue("id");
//            answer.put("name", atts.getValue("name"));
//            answer.put("shortname", atts.getValue("shortname"));
//            answer.put("status", atts.getValue("status"));
//        } else if(localName.equalsIgnoreCase("CALLS")) {
//            callsMap = new HashMap<String, Object>();
//        } else if(localName.equalsIgnoreCase("CALL")) {
//            question = new HashMap<String, Object>();
//            answer = atts.getValue("Id");
//            question.put("created", atts.getValue("created"));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        /* Gets called every time in between an opening tag and
         * a closing tag if characters are encountered. */
        question = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // Gets called every time a closing tag is encountered.
        if(localName.equalsIgnoreCase("math")) {
//            math.put("Peroid", questions);
//        } else if(localName.equalsIgnoreCase("PEROID")) {
//            questions.put("Lines", linesMap);
//        } else if(localName.equalsIgnoreCase("LINES")) {
//            linesMap.put(lineId, answer);
//        } else if(localName.equalsIgnoreCase("LINE")) {
//            answer.put("Calls", callsMap);
//        } else if(localName.equalsIgnoreCase("CALLS")) {
//            callsMap.put(answer, question);
//        } else if(localName.equalsIgnoreCase("BOOKING")) {
//            question.put("Booking", question.toString());
        }
    }

    @Override
    public void endDocument() throws SAXException {
        /* You can perform some action in this method
         * for example to reset some sort of Collection
         * or any other variable you want. It gets called
         * every time a document end is reached. */
//        SAXParsingFun.setHashMap(feed);
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        // TODO Auto-generated method stub
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length)
            throws SAXException {
        // TODO Auto-generated method stub
    }

    @Override
    public void processingInstruction(String target, String data)
            throws SAXException {
        // TODO Auto-generated method stub
    }

    @Override
    public void setDocumentLocator(Locator locator) {
        // TODO Auto-generated method stub
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
        // TODO Auto-generated method stub
    }

    @Override
    public void startPrefixMapping(String prefix, String uri)
            throws SAXException {
        // TODO Auto-generated method stub
    }
}
