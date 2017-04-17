import java.awt.event.*;
import javax.swing.*;


public class Lesson24 extends JFrame {
    JComboBox<String> favoriteShows;
    JButton button1;
    String infoOnComponent = "";

    public static void main(String[] args) {
        new Lesson24();
    }

    public Lesson24() {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Fourth Frame");
        JPanel thePanel = new JPanel();

        // ComboBox
        String[] shows = {"Breaking Bad", "Life on Mars", "Doctor Who", "Better Call Saul", "The Big Bang Theory"};
        favoriteShows = new JComboBox<>(shows);
        favoriteShows.addItem("Pushing Daisies");  // to add item at last position
        favoriteShows.insertItemAt("Dexter", 1);
        favoriteShows.setMaximumRowCount(3);
        favoriteShows.removeItem("Dexter");
        favoriteShows.removeItemAt(1);
        thePanel.add(favoriteShows);

        button1 = new JButton("Get Answer");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        this.add(thePanel);
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                favoriteShows.setEditable(true);
                System.out.println("Button Clicked! ComboBox Value: " + favoriteShows.getSelectedItem());

                infoOnComponent = "";
                infoOnComponent += "Item at 0: " + favoriteShows.getItemAt(0) + "\n";
                infoOnComponent += "Num of Shows: " + favoriteShows.getItemCount() + "\n";
                infoOnComponent += "Selected ID: " + favoriteShows.getSelectedIndex() + "\n";
                infoOnComponent += "Selected Value: " + favoriteShows.getSelectedItem() + "\n";
                infoOnComponent += "Are Editable: " + favoriteShows.isEditable() + "\n";

                JOptionPane.showMessageDialog(Lesson24.this, infoOnComponent, "Information", JOptionPane.INFORMATION_MESSAGE);

                System.out.println(infoOnComponent);
            }
        }
    }
}
