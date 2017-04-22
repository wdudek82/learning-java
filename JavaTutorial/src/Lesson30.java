import java.awt.*;

import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.*;

// TODO: It's not working as intended - I need to find all bugs
public class Lesson30 extends JFrame {

    Box sexBox, optionBox;
    JCheckBox morningCheck, afterNCheck, eveningCheck;
    JLabel nameLabel, streetLabel, stateLabel, dateLabel,
        ageLabel, sexLabel, optionsLabel, aboutLabel;
    JTextField nameText, streetText;
    JTextArea aboutYou;
    JComboBox stateList;
    JScrollPane scrollbar1;
    JSpinner dateSpin;
    JSlider ageSlider;
    JRadioButton maleRadio, femaleRadio;
    ButtonGroup sexGroup;

    public static void main(String[] args) {
        new Lesson30();
    }

    public Lesson30() {
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Random Layout");

        JPanel thePanel = new JPanel();
        thePanel.setLayout(new GridBagLayout());

        nameLabel = new JLabel("Name:");
        addComponent(thePanel, nameLabel, 0, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

        nameText = new JTextField(30);
        addComponent(thePanel, nameText, 0, 0, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        streetLabel = new JLabel("Street:");
        addComponent(thePanel, streetLabel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        streetText = new JTextField(10);
        addComponent(thePanel, streetText, 0, 1, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        sexBox = Box.createVerticalBox();
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        sexGroup = new ButtonGroup();
        sexGroup.add(maleRadio);
        sexGroup.add(femaleRadio);
        sexBox.add(maleRadio);
        sexBox.add(femaleRadio);
        sexBox.setBorder(BorderFactory.createTitledBorder("Sex"));
        addComponent(thePanel, sexBox, 3, 0, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        JPanel statePanel = new JPanel();
        statePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));

        stateLabel = new JLabel("State");
        statePanel.add(stateLabel);
        String[] states = {"PA", "NY", "OH", "WV"};
        stateList = new JComboBox(states);
        statePanel.add(stateList);

        dateLabel = new JLabel("Appointment Date");
        statePanel.add(dateLabel);
        Date todaysDate = new Date();
        dateSpin = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpin, "dd/MM/yyyy");
        dateSpin.setEditor(dateEditor);
        statePanel.add(dateSpin);

        ageLabel = new JLabel("Age: 50");
        statePanel.add(ageLabel);

        ageSlider = new JSlider(1, 130, 50);
        ageSlider.setMinorTickSpacing(1);
        ageSlider.setMajorTickSpacing(10);
        ageSlider.setPaintTicks(true);
        ageSlider.setPaintLabels(true);
        ListenForSlider lForSlider = new ListenForSlider();
        ageSlider.addChangeListener(lForSlider);
//        statePanel.add(ageSlider);
        addComponent(thePanel, sexBox, 1, 2, 5, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

        optionBox = Box.createVerticalBox();
        morningCheck = new JCheckBox("Morning");
        afterNCheck = new JCheckBox("Afternoon");
        eveningCheck = new JCheckBox("Evening");
        optionBox.add(morningCheck);
        optionBox.add(afterNCheck);
        optionBox.add(eveningCheck);
        optionBox.setBorder(BorderFactory.createTitledBorder("Time of Day"));
        addComponent(thePanel, optionBox, 1, 3, 2, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE);

        aboutYou = new JTextArea(6, 40);
        aboutYou.setText("Tell us about you");
        aboutYou.setLineWrap(true);
        aboutYou.setWrapStyleWord(true);

        scrollbar1 = new JScrollPane(aboutYou, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        addComponent(thePanel, scrollbar1, 2, 3, 3, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

        this.add(thePanel);
        this.add(statePanel);
        this.pack();
        this.setVisible(true);
    } // END OF Lesson30 CONSTRUCTOR

    private class ListenForSlider implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            if(e.getSource() == ageSlider) {
                ageLabel.setText("Age: " + ageSlider.getValue());
                System.out.println("Age slider");
            }
        }
    } // END OF ListenForSlider METHOD

    private void addComponent(JPanel thePanel, JComponent component, int xPos, int yPos, int compWidth, int compHeight, int place, int stretch) {
        GridBagConstraints gridConstraints = new GridBagConstraints();

        gridConstraints.gridx = xPos;
        gridConstraints.gridy = yPos;
        gridConstraints.gridwidth = compWidth;
        gridConstraints.gridheight = compHeight;
        gridConstraints.weightx = 100;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(5, 5, 5, 5);
        gridConstraints.anchor = place;
        gridConstraints.fill = stretch;

        thePanel.add(component, gridConstraints);
    }

} // END OF Lesson30 CLASS
