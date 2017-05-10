import org.xml.sax.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.IOException;


public class Lesson44 {
    public static void main(String[] args) {
        Document xmlDoc = getDocument("xml/tvshows5.xml");

        System.out.println(System.getProperty("user.dir"));

        NodeList listOfShows = xmlDoc.getElementsByTagName("show");

        System.out.println("Number of shows: " + listOfShows.getLength());

        String elementName = "network";
        String attrName = "country";

        getElementAndAttrib(listOfShows, elementName, attrName);

        try {
            System.out.println("Root: " + xmlDoc.getDocumentElement().getNodeName());

        } catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }

    } // END OF main

    private static void getElementAndAttrib(NodeList listOfShows, String elementName, String attrName) {
        try {
            for(int i = 0; i < listOfShows.getLength(); i++) {
                Node showNode = listOfShows.item(i);
                Element showElement = (Element) showNode;
                NodeList networkList = showElement.getElementsByTagName(elementName);
                Element networkElement = (Element) networkList.item(0);
                NodeList elementList = networkElement.getChildNodes();

                if(networkElement.hasAttribute(attrName)) {
                    System.out.println(elementName + ": " +
                            ((Node) elementList.item(0)).getNodeValue().trim() +
                            " has atribute " + networkElement.getAttribute(elementName)
                    );
                } else {
                    System.out.println(elementName + ": " +
                            ((Node) elementList.item(0)).getNodeValue().trim()
                    );
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    } // END OF getElementAndAttrib METHOD

    private static Document getDocument(String docString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            factory.setValidating(true);

            DocumentBuilder builder = factory.newDocumentBuilder();

            return builder.parse(new InputSource(docString));

        } catch (ParserConfigurationException e1) {
            e1.printStackTrace();
        } catch (SAXException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }

        return null;
    } // END OF getDocument METHOD
} // END OF Lesson44 CLASS
