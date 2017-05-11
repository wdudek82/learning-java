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
        } catch(ParserConfigurationException e1) {
            e1.printStackTrace();
        } catch (SAXException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }

        XPath xpath = XPathFactory.newInstance().newXPath();
        getNodeNameAndValue(doc, xpath);
    }

    private static void getNodeNameAndValue(Document doc, XPath xpath) {
        XPathExpression expr;
        Object result = null;

        try {
            expr = xpath.compile("//show/name//text()");
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
