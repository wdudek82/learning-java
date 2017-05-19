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

        brushBut = makeMeButtons("Brush","./img/brush2.png", 1);
        lineBut = makeMeButtons("Line", "./img/line.png", 2);
        ellipseBut = makeMeButtons("Ellipse", "./img/ellipse.png", 3);
        rectBut = makeMeButtons("Rectangle", "./img/rect.png", 4);

        strokeBut = makeMeColorButton("Stroke","./img/stroke.png", 5, true);
        fillBut = makeMeColorButton("Fill","./img/fill.png", 6, false);

        theBox.add(brushBut);
        theBox.add(lineBut);
        theBox.add(ellipseBut);
        theBox.add(rectBut);
        theBox.add(strokeBut);
        theBox.add(fillBut);

        buttonPanel.add(theBox);

        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(new DrawingBoard(), BorderLayout.CENTER);

        this.setVisible(true);

    }

    private JButton makeMeButtons(String label, String icon, final int action) {
        JButton theButton = new JButton(label);
        // Icon buttonIcon = new ImageIcon(icon);
        // theButton.setIcon(buttonIcon);

        theButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               currentAction = action;

               System.out.println("button clicked!");
           }

        });

        return theButton;
    }

    private JButton makeMeColorButton(String label, String icon, final int action, final boolean stroke) {
        JButton theButton = new JButton(label);
        // Icon buttonIcon = new ImageIcon(icon);
        // theButton.setIcon(buttonIcon);

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
        ArrayList<Color> fill = new ArrayList<>();
        ArrayList<Color> stroke = new ArrayList<>();
        Point drawStart, drawEnd;

        public DrawingBoard() {
            this.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    drawStart = new Point(e.getX(), e.getY());
                    drawEnd = drawStart;
                    repaint();
                }

                public void mouseReleased(MouseEvent e) {
                    Shape shape = drawRectangle(drawStart.x, drawEnd.y, e.getX(), e.getY());
                    shapes.add(shape);
                    fill.add(fillColor);
                    stroke.add(strokeColor);

                    drawStart = null;
                    drawEnd = null;
                    repaint();
                }
            }); // END OF addMouseListener METHOD

            this.addMouseMotionListener(new MouseMotionAdapter() {
               public void mouseDragged(MouseEvent e) {
                   drawEnd = new Point(e.getX(), e.getY());
                   repaint();
               }
            }); // END OF addMouseMotionListener METHOD
        } // END OF DrawingBoard CONSTRUCTOR

        public void paint(Graphics g) {
            Graphics2D graphSettings = (Graphics2D) g;
            graphSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphSettings.setStroke(new BasicStroke(2));
            Iterator<Color> strokeCounter = stroke.iterator();
            Iterator<Color> fillCounter =  fill.iterator();

            graphSettings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

            for(Shape s: shapes) {
                graphSettings.setPaint(strokeCounter.next());
                graphSettings.draw(s);

                graphSettings.setPaint(fillCounter.next());
                graphSettings.fill(s);
            }

            if(drawStart != null && drawEnd != null) {
                graphSettings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
                graphSettings.setPaint(Color.LIGHT_GRAY);

                Shape shape = drawRectangle(drawStart.x, drawStart.y, drawEnd.x, drawEnd.y);
                graphSettings.draw(shape);
            }
        } // END OF pain METHOD
    } // END OF DrawingBoard CLASS

    private Rectangle2D.Float drawRectangle(int x1, int y1, int x2, int y2) {
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);

        int width = Math.abs(x1 - x2);
        int height = Math.abs(y1 - y2);

        return new Rectangle2D.Float(x, y, width, height);
    } // END OF drawRectangle METHOD
}
