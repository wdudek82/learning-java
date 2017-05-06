import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;


public class Lesson39 extends JFrame implements HyperlinkListener, ActionListener {

    public static void main(String[] args) {
        new Lesson39("file:///home/neevor/code/java/learning-java/JavaTutorial/html/htmlexamp.html");
    }

    String defaultURL;
    JPanel toolPanel = new JPanel();
    JTextField theURL = new JTextField(25);

    JEditorPane htmlPage;

    public Lesson39(String defaultURL) {
        JFrame frame = new JFrame("Java Browser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.defaultURL = defaultURL;

        theURL.addActionListener(this);
        theURL.setText(defaultURL);

        toolPanel.add(theURL);

        frame.add(toolPanel, BorderLayout.NORTH);

        try {
            htmlPage = new JEditorPane(defaultURL);
            htmlPage.addHyperlinkListener(this);
            htmlPage.setEditable(false);

            JScrollPane scroller = new JScrollPane(htmlPage);

            frame.add(scroller, BorderLayout.CENTER);
        } catch(IOException e1) {
            e1.printStackTrace();
        }

        frame.setSize(1200, 800);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pageURL = "";

        if(e.getSource() == theURL) {
            pageURL = theURL.getText();
        } else {
            JOptionPane.showMessageDialog(
                    Lesson39.this,
                    "Please Enter a Web Address",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        try {
            htmlPage.setPage(new URL(pageURL));
        } catch (MalformedURLException e1) {
            JOptionPane.showMessageDialog(
                    Lesson39.this,
                    "Please Use http://",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

    }

    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {
        if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            try {
                htmlPage.setPage(e.getURL());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            theURL.setText(e.getURL().toExternalForm());
        }

    }
}
