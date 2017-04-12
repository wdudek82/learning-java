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

        this.setVisible(true);
    }

}
