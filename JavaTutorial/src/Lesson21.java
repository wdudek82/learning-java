import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;  // to listen events in GUI
import java.net.URL;


public class Lesson21 extends JFrame {
    JButton button1;
    JButton button2;
    JTextField textField1;
    JTextArea textArea1;
    int button1Clicked;
    int button2Clicked;

    public static void main(String[] args) {
        new Lesson21();
    }

    public Lesson21() {
        URL iconURL = getClass().getResource("penguin.png");
        ImageIcon icon = new ImageIcon(iconURL);

        this.setSize(400, 400);
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

        // Buttons
        ListenForButton lForButton = new ListenForButton();

        button1 = new JButton("Send");
//        button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        button2 = new JButton("button2");
        button2.setContentAreaFilled(false);
        button2.setText("Cancel");
        button2.addActionListener(lForButton);
        button2.setToolTipText("My second button");
        thePanel.add(button2);

        // Textfield
        textField1 = new JTextField("", 15);
        ListenForKeys lForKeys = new ListenForKeys();
        textField1.addKeyListener(lForKeys);
        textField1.setToolTipText("Type something here");
        textField1.setColumns(30);
        thePanel.add(textField1);

        textArea1 = new JTextArea("Tracking Events\n", 19, 30);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea1.setToolTipText("Some tooltip for text area 1");
        int numOfLines = textArea1.getLineCount();
        textArea1.append("\nnumber of lines: " + numOfLines + "\n\n");
        thePanel.add(textArea1);

        // Scrollbar for textArea1
        JScrollPane scrollbar1 = new JScrollPane(
                textArea1,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );
        thePanel.add(scrollbar1);

        this.add(thePanel);


        this.setVisible(true);

        textField1.requestFocus();

        ListenForWindow lForWindow = new ListenForWindow();
        this.addWindowListener(lForWindow);

        ListenForMouse lForMouse = new ListenForMouse();
        textArea1.addMouseListener(lForMouse);
    }

    private class ListenForButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button1) {
                button1Clicked++;
                textArea1.append("Send clicked " + button1Clicked + " times\n");
                System.out.println("Clicked 1: " + button1Clicked);
//                System.out.println("e.getSource: " + e.getSource().toString() + "\n");
            } else if (e.getSource() == button2) {
                button2Clicked++;
                textArea1.append("Cancel clicked " + button2Clicked + " times\n");
                System.out.println("Clicked 2: " + button2Clicked);
            }
        }

    }

    private class ListenForKeys implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            textArea1.append("Key hit: " + e.getKeyChar() + "\n");
        }

        @Override
        public void keyReleased(KeyEvent e) {
//            textArea1.append("Key released: " + e.getKeyChar() + "\n");
        }

        @Override
        public void keyTyped(KeyEvent e) {
//            textArea1.append("Key typed: " + e.getKeyChar() + "\n");
        }
    }

    private class ListenForWindow implements WindowListener {
        @Override
        public void windowOpened(WindowEvent e) {
            System.out.println("Windows opened");
        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("Windows closing...");
        }

        @Override
        public void windowClosed(WindowEvent e) {
            //
        }

        @Override
        public void windowIconified(WindowEvent e) {
            System.out.println("Window iconified");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            System.out.println("Window deiconified");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println("Window activated");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            System.out.println("Window deactivated");
        }
    }

    private class ListenForMouse implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
//            System.out.println("Mouse Clicked");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("Mouse Pressed: X " + e.getX() + ", Y " + e.getY());
            System.out.println("Mouse Pressed (Screen): X " + e.getXOnScreen() + ", Y " + e.getYOnScreen());
            System.out.println("Mouse Button: " + e.getButton());
            System.out.println("Mouse Clicks: " + e.getClickCount());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("Mouse Released: X " + e.getX() + ", Y " + e.getY());
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("Mouse Entered: X " + e.getX() + ", Y " + e.getY());
        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("Mouse Exited: X " + e.getX() + ", Y " + e.getY());
        }
    }
}