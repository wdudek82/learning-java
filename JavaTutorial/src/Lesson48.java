import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;


public class Lesson48 extends JFrame {

    JButton brushBut, lineBut, ellipseBut, rectBut, strokeBut, fillBut;
    int currentAction = 1;
    Color strokeColor = Color.black, fillColor = Color.black;

    public static void main(String[] args) {
        new Lesson48();
    }

    public Lesson48() {
        this.setSize(500, 500);
        this.setTitle("Java Paint");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();

        Box theBox = Box.createHorizontalBox();

        brushBut = makeMeButtons("./img/brush2.png", 1);
        lineBut = makeMeButtons("./img/line.png", 2);
        ellipseBut = makeMeButtons("./img/ellipse.png", 3);
        rectBut = makeMeButtons("./img/rect.png", 4);

        strokeBut = makeMeColorButton("./img/stroke.png", 5, true);
        fillBut = makeMeColorButton("./img/fill.png", 6, false);

        theBox.add(brushBut);
        theBox.add(lineBut);
        theBox.add(ellipseBut);
        theBox.add(rectBut);
        theBox.add(strokeBut);
        theBox.add(fillBut);

        buttonPanel.add(theBox);

        this.add(buttonPanel, BorderLayout.SOUTH);
        // this.add(new DrawingBoard(), BorderLayout.CENTER);

        this.setVisible(true);

    }

    private JButton makeMeButtons(String icon, final int action) {
        JButton theButton = new JButton();
        Icon buttonIcon = new ImageIcon(icon);
        theButton.setIcon(buttonIcon);

        theButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               currentAction = action;

               System.out.println("button clicked!");
           }

        });

        return theButton;
    }

    private JButton makeMeColorButton(String icon, final int action, final boolean stroke) {
        JButton theButton = new JButton();
        Icon buttonIcon = new ImageIcon(icon);
        theButton.setIcon(buttonIcon);

        theButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentAction = action;
                if(stroke) {
                    strokeColor = JColorChooser.showDialog(null, "Pick a Stroke", Color.BLACK);
                } else {
                    fillColor = JColorChooser.showDialog(null, "Pick a Fill", Color.BLACK);
                }
            }
        });

        return theButton;
    }

    private class DrawingBoard extends JComponent {
        ArrayList<Shape> shapes = new ArrayList<>();
    }

}
