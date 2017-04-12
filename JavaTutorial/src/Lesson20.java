import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.net.URL;

public class Lesson20 extends JFrame {
    public static void main(String[] args) {
        new Lesson20();

    }

    public Lesson20() {
        URL iconURL = getClass().getResource("penguin.png");
        ImageIcon icon = new ImageIcon(iconURL);

        this.setSize(400, 400);
//        this.setLocationRelativeTo(null);  // center frame

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 4) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);

        this.setLocation(xPos, yPos);

        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("Foo Bar Baz");
        this.setIconImage(icon.getImage());

        // Setting the panel
        JPanel thePanel = new JPanel();
        JLabel label1 = new JLabel("Tell me something");
        label1.setToolTipText("Example Tooltip");
        thePanel.add(label1);

        JLabel label2 = new JLabel("Tell me something new");
        label2.setText("New Text");
        thePanel.add(label2);

        // Button
        JButton button1 = new JButton("Send");
//        button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);
        thePanel.add(button1);

        JButton button2 = new JButton("button2");
        button2.setContentAreaFilled(false);
        button2.setText("Cancel");
        button2.setToolTipText("My second button");
        thePanel.add(button2);

        // Textfield
        JTextField textField1 = new JTextField("phone number", 15);
        textField1.setToolTipText("Type something here");
        textField1.setColumns(30);
        thePanel.add(textField1);

        JTextArea textArea1 = new JTextArea("message\n\n", 19, 30);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea1.setToolTipText("Some tooltip for text area 1");
        int numOfLines = textArea1.getLineCount();
        textArea1.append("\nnumber of lines: " + numOfLines);
        thePanel.add(textArea1);

        // Scrollbar for textArea1
        JScrollPane scrollbar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        thePanel.add(scrollbar1);

        this.add(thePanel);

        this.setVisible(true);

        textField1.requestFocus();
    }

}
