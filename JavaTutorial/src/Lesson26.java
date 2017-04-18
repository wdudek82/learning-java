import java.awt.event.*;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Lesson26 extends JFrame {

    JButton button1;
    JSpinner spinner1, spinner2, spinner3, spinner4;
    String outputString;

    public static void main(String[] args) {
        new Lesson26();
    }

    public Lesson26() {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My 5th Frame - Spinners");

        JPanel thePanel = new JPanel();

        // Create a button
        button1 = new JButton("Get Answer");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        // Create a spinner
        spinner1 = new JSpinner();
        thePanel.add(spinner1);

        spinner2 = new JSpinner(new SpinnerNumberModel(5, 1, 100, 1));
        thePanel.add(spinner2);

        String[] weekDays = {"Mon", "Tues", "Weds", "Thurs", "Fri", "Sat", "Sun"};
        spinner3 = new JSpinner(new SpinnerListModel(weekDays));
        Dimension d = spinner3.getPreferredSize();
        d.width = 80;
        spinner3.setPreferredSize(d);
        thePanel.add(spinner3);

        Date todaysDate = new Date();
        spinner4 = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner4, "dd/MM/yyyy");
        spinner4.setEditor(dateEditor);
        ListenForSpinner lForSpinner = new ListenForSpinner();
        spinner4.addChangeListener(lForSpinner);
        thePanel.add(spinner4);

        this.add(thePanel);
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                outputString = "";
                outputString += "Spinner 1 Value: " + spinner1.getValue() + "\n";
                outputString += "Spinner 2 Value: " + spinner2.getValue() + "\n";
                outputString += "Spinner 3 Value: " + spinner3.getValue() + "\n";
                outputString += "Spinner 4 Value: " + spinner4.getValue() + "\n";

                JOptionPane.showMessageDialog(Lesson26.this, outputString, "Spinners' Values", JOptionPane.INFORMATION_MESSAGE);

                System.out.println("Clicked!");
            }
        }
    }

    private class ListenForSpinner implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            System.out.printf("4th Spinner state changed\n");
        }
    }
}
