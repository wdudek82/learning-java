import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.*;


public class Lesson29 extends JFrame {
    JButton but1, but2, but3, but4, but5, but6,
            but7, but8, but9, but0, butPlus, butMinus,
            clearAll;
    JTextField textResult;

    public static void main(String[] args) {
        new Lesson29();
    }

    public Lesson29() {
        this.setSize(400, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");

        JPanel thePanel = new JPanel();

//        thePanel.setLayout(new GridLayout(0, 3, 2, 2));
        thePanel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 5;
        gridConstraints.gridheight = 1;
        gridConstraints.weightx = 50;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(5, 5, 5, 5);
        gridConstraints.anchor = GridBagConstraints.CENTER;
        gridConstraints.fill = GridBagConstraints.BOTH;


        textResult = new JTextField("0", 50);
        textResult.setEditable(false);
        textResult.setBackground(Color.white);
        Font font = new Font("Helvetica", Font.PLAIN, 18);
        textResult.setFont(font);

        clearAll = new JButton("C"); clearAll.setContentAreaFilled(false);
        but1 = new JButton("1"); but1.setContentAreaFilled(false);
        but2 = new JButton("2"); but2.setContentAreaFilled(false);
        but3 = new JButton("3"); but3.setContentAreaFilled(false);
        but4 = new JButton("4"); but4.setContentAreaFilled(false);
        but5 = new JButton("5"); but5.setContentAreaFilled(false);
        but6 = new JButton("6"); but6.setContentAreaFilled(false);
        but7 = new JButton("7"); but7.setContentAreaFilled(false);
        but8 = new JButton("8"); but8.setContentAreaFilled(false);
        but9 = new JButton("9"); but9.setContentAreaFilled(false);
        butPlus = new JButton("+"); butPlus.setContentAreaFilled(false);
        but0 = new JButton("0"); but0.setContentAreaFilled(false);
        butMinus = new JButton("-"); butMinus.setContentAreaFilled(false);

        thePanel.add(textResult, gridConstraints);
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 9;
        thePanel.add(clearAll, gridConstraints);
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        thePanel.add(but1, gridConstraints);
        gridConstraints.gridx = 5;
        thePanel.add(but2, gridConstraints);
        gridConstraints.gridx = 9;
        thePanel.add(but3, gridConstraints);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 3;
        thePanel.add(but4, gridConstraints);
        gridConstraints.gridx = 5;
        thePanel.add(but5, gridConstraints);
        gridConstraints.gridx = 9;
        thePanel.add(but6, gridConstraints);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 4;
        thePanel.add(but7, gridConstraints);
        gridConstraints.gridx = 5;
        thePanel.add(but8, gridConstraints);
        gridConstraints.gridx = 9;
        thePanel.add(but9, gridConstraints);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 5;
        thePanel.add(butPlus, gridConstraints);
        gridConstraints.gridx = 5;
        thePanel.add(but0, gridConstraints);
        gridConstraints.gridx = 9;
        thePanel.add(butMinus, gridConstraints);

        this.add(thePanel);
        this.setVisible(true);
    } // END OF Lesson29 CONSTRUCTOR
} // END OF Lesson29 CLASS
