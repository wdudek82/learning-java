import com.sun.org.apache.xpath.internal.SourceTree;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Lesson25 extends JFrame {
    JButton button1;
    String infoOnComponent = "";
    JList favoriteMovies, favoriteColors;
    DefaultListModel defListModel = new DefaultListModel();
    JScrollPane scroller;

    public static void main(String[] args) {
        new Lesson25();
    }

    public Lesson25() {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Fifth Frame");

        JPanel thePanel = new JPanel();

        button1 = new JButton("Get Answer");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        String[] movies = {"Interview with the Vampire", "Star Wars", "Star Trek", "Matrix", "Minority Report"};
        favoriteMovies = new JList(movies);
        favoriteMovies.setFixedCellHeight(30);
        favoriteMovies.setFixedCellWidth(150);
        favoriteMovies.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        thePanel.add(favoriteMovies);

        String[] colors = {"Red", "Yellow", "Orange", "Green", "Blue"};
//        favoriteColors = new JList(colors);
//        thePanel.add(favoriteColors);

        for(String color: colors) {
            defListModel.addElement(color);
        }
        defListModel.add(2, "Pink");
        favoriteColors = new JList(defListModel);
        favoriteColors.setVisibleRowCount(4);
        scroller = new JScrollPane(
                favoriteColors,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );
        favoriteColors.setFixedCellHeight(30);
        favoriteColors.setFixedCellWidth(150);
        thePanel.add(scroller); // I must add scroller, not favoriteColors

        this.add(thePanel);
        this.setVisible(true);

    }

    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                if(defListModel.contains("Pink")) {
                    System.out.println("Pink is here");
                }

                if(!defListModel.isEmpty()) {
                    System.out.println("Colors List isn't empty");
                }

                infoOnComponent = "";
                infoOnComponent += "Selected Movies: " + favoriteMovies.getSelectedValuesList() + "\n";
                infoOnComponent += "Selected Colors: " + defListModel.size() + " " + favoriteColors.getSelectedValuesList() + "\n";

                JOptionPane.showMessageDialog(Lesson25.this, infoOnComponent, "Selected Items", JOptionPane.INFORMATION_MESSAGE);

//                Object[] arrayOfList = defListModel.toArray();
//
//                for(Object color: arrayOfList) {
//                    System.out.println("Array: " + color);
//                }

                System.out.println("Clicked: " + favoriteMovies.getSelectedValuesList());
                System.out.println("Clicked: " + favoriteColors.getSelectedValuesList() + "\n");
            }
        }
    }
}
