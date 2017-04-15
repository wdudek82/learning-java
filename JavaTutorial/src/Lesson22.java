import java.awt.event.*;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Lesson22 extends JFrame {

    JButton button1;
    JLabel label1, label2, label3;
    JTextField textField1, textField2;
    JCheckBox dollarSign, commaSeparator;
    JRadioButton addNums, subtractNums, multNums, divideNums;
    JSlider howManyTimes;

    double number1, number2, totalCalc;

    public static void main(String[] args) {
        new Lesson22();
    }

    public Lesson22() {
        // setup frame
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Third Frame");

        // setup panel
        JPanel thePanel = new JPanel();

        // create button1 & connect action listener
        button1 = new JButton("Calculate");
        button1.setContentAreaFilled(false);
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        // setup label1
        label1 = new JLabel("Number 1");
        thePanel.add(label1);

        // setup textField1
        textField1 = new JTextField("", 5);
        thePanel.add(textField1);

        label2 = new JLabel("Number 2");
        thePanel.add(label2);

        textField2 = new JTextField("", 5);
        thePanel.add(textField2);

        // checkboxes
        dollarSign = new JCheckBox("Dollar");
        commaSeparator = new JCheckBox("Commas");
        thePanel.add(dollarSign);
        thePanel.add(commaSeparator, true);
//        commaSeparator.setSelected(true);

        // radio button
        addNums = new JRadioButton("Add");
        subtractNums = new JRadioButton("Subtract");
        multNums = new JRadioButton("Multiply");
        divideNums = new JRadioButton("Divide");

        ButtonGroup operation = new ButtonGroup();
        operation.add(addNums);
        operation.add(subtractNums);
        operation.add(multNums);
        operation.add(divideNums);

        JPanel operationPanel = new JPanel();
        Border operationBorder = BorderFactory.createTitledBorder("Operation");
        operationPanel.setBorder(operationBorder);
        operationPanel.add(addNums);
        operationPanel.add(subtractNums);
        operationPanel.add(multNums);
        operationPanel.add(divideNums);
        addNums.setSelected(true);
        thePanel.add(operationPanel);

        label3 = new JLabel("Perform How Many Times");
        thePanel.add(label3);

        howManyTimes = new JSlider(0, 99, 1);
        howManyTimes.setMinorTickSpacing(1);
        howManyTimes.setMajorTickSpacing(10);
        howManyTimes.setPaintTicks(true);
        howManyTimes.setPaintLabels(true);
//        howManyTimes.setPaintTrack(true);
        ListenForSlider lForSlider = new ListenForSlider();
        howManyTimes.addChangeListener(lForSlider);
        thePanel.add(howManyTimes);

        this.add(thePanel);
        this.setVisible(true);
        textField1.requestFocus();
    }

    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                System.out.println("Val 1: " + textField1.getText() + " Val 2: " + textField2.getText() + " operation: ");
            }
        }
    }

    private class ListenForSlider implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            System.out.println("Slider value: " + howManyTimes.getValue());
        }
    }
}
