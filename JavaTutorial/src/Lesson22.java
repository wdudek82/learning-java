import java.awt.event.*;
import java.text.NumberFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Lesson22 extends JFrame {

    private JButton button1;
    private JLabel label1, label2, label3;
    private JTextField textField1, textField2;
    private JCheckBox dollarSign, commaSeparator;
    private JRadioButton addNums, subtractNums, multNums, divideNums;
    private JSlider howManyTimes;

    private double number1, number2, totalCalc;

    public static void main(String[] args) {
        new Lesson22();
    }

    public Lesson22() {
        // setup frame
        this.setSize(400, 250);
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

        label3 = new JLabel("Perform How Many Times 0");
        thePanel.add(label3);

        howManyTimes = new JSlider(0, 99, 1);
        howManyTimes.setMinorTickSpacing(1);
        howManyTimes.setMajorTickSpacing(10);
        howManyTimes.setPaintTicks(true);
        howManyTimes.setPaintLabels(true);
        ListenForSlider lForSlider = new ListenForSlider();
        howManyTimes.addChangeListener(lForSlider);
        thePanel.add(howManyTimes);

        this.add(thePanel);
        this.setVisible(true);
        textField1.requestFocus();
    }

//    private class ListenForButton implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if(e.getSource() == button1) {
//                System.out.println("Val 1: " + textField1.getText() + " Val 2: " + textField2.getText() + " operation: ");
//            }
//        }
//    }

    private class ListenForButton implements ActionListener {
        // Experimenting with Java's Lambdas... and they are weird...
//        MathOperation add = (int num1, int num2) -> num1 + num2;
//        MathOperation sub = (int num1, int num2) -> num1 - num2;
//        MathOperation mul = (int num1, int num2) -> num1 * num2;
//        MathOperation div = (int num1, int num2) -> num1 * num2;

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                try {
                    number1 = Double.parseDouble(textField1.getText());
                    number2 = Double.parseDouble(textField2.getText());
                } catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            Lesson22.this,
                            "Please Enter the Right Info",
                            "Error", JOptionPane.ERROR_MESSAGE
                    );
                    // System.exit(0);
                }

                if(addNums.isSelected()) {
                    totalCalc = mathOp("add", number1, number2) * howManyTimes.getValue();
                    System.out.printf("\n%.1f + %.1f = %.1f\n", number1, number2, totalCalc);
                } else if(subtractNums.isSelected()) {
                    totalCalc = mathOp("sub", number1, number2) * howManyTimes.getValue();
                    System.out.printf("\n%.1f - %.1f = %.1f\n", number1, number2, totalCalc);
                } else if(multNums.isSelected()) {
                    totalCalc = mathOp("mul", number1, number2) * howManyTimes.getValue();
                    System.out.printf("\n%.1f * %.1f = %.1f\n", number1, number2, totalCalc);
                } else {
                    totalCalc = mathOp("div", number1, number2) * howManyTimes.getValue();
                    System.out.printf("\n%.1f / %.1f = %.1f\n", number1, number2, totalCalc);
                }

                if(dollarSign.isSelected()) {
                    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
                    JOptionPane.showMessageDialog(Lesson22.this, numberFormat.format(totalCalc), "Solution", JOptionPane.INFORMATION_MESSAGE);
                } else if(commaSeparator.isSelected()) {
                    NumberFormat numberFormat = NumberFormat.getNumberInstance();
                    JOptionPane.showMessageDialog(Lesson22.this, numberFormat.format(totalCalc), "Solution", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(Lesson22.this, totalCalc, "Solution", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    private class ListenForSlider implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            if(e.getSource() == howManyTimes) {
                label3.setText("Perform How Many Times? " + howManyTimes.getValue());
            }
        }
    }

    private static double mathOp(String operation, double num1, double num2) {
        double result = 0;
        switch(operation) {
            case("add"):
                result = (num1 + num2);
                break;

            case("sub"):
                result = (num1 - num2);
                break;

            case("mul"):
                result = (num1 * num2);
                break;

            case("div"):
                result = (num1 / num2);
                break;
        }
        return result;
    }

    interface MathOperation {
        int operation(int num1, int num2);
    }
}
