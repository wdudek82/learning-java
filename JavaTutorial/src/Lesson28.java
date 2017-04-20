import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;


public class Lesson28 extends JFrame {

    JButton button1, button2, button3, button4, button5;

    public static void main(String[] args) {
        new Lesson28();
    }

    public Lesson28() {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Lesson 28 - Swing Layout Managers");

        // Flow Layout
        JPanel thePanel1 = new JPanel();
//        thePanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
//
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        button3 = new JButton("Button 3");
        button4 = new JButton("Button 4");
        button5 = new JButton("Button 5");

//        thePanel1.add(button1);
//        thePanel1.add(button2);
//        thePanel1.add(button3);

        // Border Layout
        JPanel thePanel2 = new JPanel();
//        thePanel2.setLayout(new BorderLayout());
//        thePanel2.add(button1, BorderLayout.NORTH);
//        thePanel2.add(button2, BorderLayout.NORTH);
//        thePanel2.add(button3, BorderLayout.EAST);
//        thePanel2.add(button4, BorderLayout.WEST);
//        thePanel2.add(button5, BorderLayout.CENTER);
//        thePanel1.add(thePanel2);

        // Border Layout - another example
//        thePanel2.add(button1);
//        thePanel2.add(button2);
//        thePanel2.add(button3);
//        thePanel2.add(button4);
//        thePanel2.add(button5);
//        thePanel1.add(thePanel2, BorderLayout.NORTH);

//        this.add(thePanel1);

        // Box Layout
        Box theBox = Box.createHorizontalBox();
        theBox.add(button1);
        theBox.add(Box.createHorizontalStrut(4));
        theBox.add(button2);
//        theBox.add(Box.createHorizontalGlue());
        theBox.add(Box.createRigidArea(new Dimension(30, 20)));
        theBox.add(button3);
        this.add(theBox);

        this.setVisible(true);
    }
}
