import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class Lesson46 {

    public static void main(String[] args) {

        // writeXML();
        readXML();

    }

    private static void writeXML() {
        Document doc = new Document();

        Element theRoot = new Element("tvshows");
        doc.setRootElement(theRoot);

        // ---------------------

        Element show = new Element("show");

        Element name = new Element("name");
        name.setAttribute("show_id", "show_001");
        name.addContent(new Text("Life on Mars"));

        Element network = new Element("network");
        network.setAttribute("country", "US");
        network.addContent(new Text("ABC"));

        show.addContent(name);
        show.addContent(network);

        theRoot.addContent(show);

        // ---------------------

        XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());

        try {
            xmlOutput.output(doc, new FileOutputStream(new File("./xml/jdomMade.xml")));
        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("Wrote to file");
    }

    private static void readXML() {
        SAXBuilder builder = new SAXBuilder();

        try {
            Document readDoc = builder.build(new File("./xml/jdomMade.xml"));
            System.out.println("Root: " + readDoc.getRootElement());
            System.out.println("Show: " +
                    readDoc.getRootElement().getChild("show").getChildText("name"));
            System.out.println("Show ID: " +
                    readDoc.getRootElement().getChild("show").getChild("name").getAttributes());

            Element root = readDoc.getRootElement();

            System.out.println();
            for(Element curElement: root.getChildren("show")) {
                System.out.println("Show ID: " +
                        curElement.getChild("name").getAttributeValue("show_id"));
                System.out.println("Show Name: " +
                        curElement.getChildText("name"));
                System.out.println("Network: " +
                        curElement.getChildText("network") + " in the " +
                        curElement.getChild("network").getAttributeValue("country") + "\n");
            }

        } catch(IOException | JDOMException e) {
            e.printStackTrace();
        }

    }
}

