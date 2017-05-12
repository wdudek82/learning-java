import org.w3c.dom.*;  // Document, element, node, nodelists, text, exceptions,
import javax.xml.xpath.*;
import javax.xml.parsers.*;  // DocumentBuilder, DocumentBuilderFactory, SAXParser
import java.io.IOException;
import org.xml.sax.SAXException;


public class Lesson45 {
    public static void main(String[] args) {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);

        DocumentBuilder builder;
        Document doc = null;

        try {
            builder = domFactory.newDocumentBuilder();
            doc = builder.parse("./xml/tvshows5.xml");
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        } catch(ParserConfigurationException e) {
            e.printStackTrace();
        }

        XPath xpath = XPathFactory.newInstance().newXPath();
        getNodeNameAndValue(doc, xpath);
    }

    private static void getNodeNameAndValue(Document doc, XPath xpath) {
        XPathExpression expr;
        Object result = null;

        try {
//            expr = xpath.compile("//show/name//text()");
//            expr = xpath.compile("//show/name[@id_code='show_003']//text()");
//            expr = xpath.compile("//show/network[@country='US']//text()");
            expr = xpath.compile("//show/actors/actor/character[@profession='Student']//text()");
            result = expr.evaluate(doc, XPathConstants.NODESET);
        } catch(XPathExpressionException e) {
            e.printStackTrace();
        }

        NodeList nodes = (NodeList) result;

        for(int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getParentNode().getNodeName() + " " +
                nodes.item(i).getNodeValue());
        }
    }
}
