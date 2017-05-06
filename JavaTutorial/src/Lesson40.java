import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;


public class Lesson40 extends JApplet {

    JPanel thePanel;
    JPanel ques1Panel, ques2Panel, ques3Panel, ques4Panel;
    JButton getResultBut;
    JRadioButton extravertRadio, introvertRadio,
        sensorRadio, intuitiveRadio, feelerRadio,
        thinkerRadio, judgingRadio, perceivingRadio;
    JEditorPane yourReport;

    // in Java applets we use init instead of main function
    public void init() {
        this.setSize(675, 870);

        thePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        ques1Panel = new JPanel();
        ques2Panel = new JPanel();
        ques3Panel = new JPanel();
        ques4Panel = new JPanel();

        Border border1 = BorderFactory.createTitledBorder("Do you prefer to work");
        Border border2 = BorderFactory.createTitledBorder("Which is most important");
        Border border3 = BorderFactory.createTitledBorder("Do you act on");
        Border border4 = BorderFactory.createTitledBorder("Which do you prefer");

        ques1Panel.setBorder(border1);
        ques2Panel.setBorder(border2);
        ques3Panel.setBorder(border3);
        ques4Panel.setBorder(border4);

        ButtonGroup group1 = new ButtonGroup();
        ButtonGroup group2 = new ButtonGroup();
        ButtonGroup group3 = new ButtonGroup();
        ButtonGroup group4 = new ButtonGroup();

        extravertRadio = new JRadioButton("In groups");
        introvertRadio = new JRadioButton("On your own");
        sensorRadio = new JRadioButton("The specifics");
        intuitiveRadio = new JRadioButton("The big picture");
        feelerRadio = new JRadioButton("What feels right");
        thinkerRadio = new JRadioButton("List of facts");
        judgingRadio = new JRadioButton("To plan");
        perceivingRadio = new JRadioButton("To adapt");

        extravertRadio.setSelected(true);
        sensorRadio.setSelected(true);
        feelerRadio.setSelected(true);
        judgingRadio.setSelected(true);

        ques1Panel.add(extravertRadio);
        ques1Panel.add(introvertRadio);
        ques2Panel.add(sensorRadio);
        ques2Panel.add(intuitiveRadio);
        ques3Panel.add(feelerRadio);
        ques3Panel.add(thinkerRadio);
        ques4Panel.add(judgingRadio);
        ques4Panel.add(perceivingRadio);

        group1.add(extravertRadio);
        group1.add(introvertRadio);
        group2.add(sensorRadio);
        group2.add(intuitiveRadio);
        group3.add(feelerRadio);
        group3.add(thinkerRadio);
        group4.add(judgingRadio);
        group4.add(perceivingRadio);

        thePanel.add(ques1Panel);
        thePanel.add(ques2Panel);
        thePanel.add(ques3Panel);
        thePanel.add(ques4Panel);

        getResultBut = new JButton("Get Result");
        GetResultsListener butListener = new GetResultsListener();
        getResultBut.addActionListener(butListener);
        thePanel.add(getResultBut);

        this.add(thePanel);
        this.setVisible(true);
    }

    class GetResultsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String pageToOpen = "",
                    directoryLoc = "file:///home/neevor/code/java/learning-java/JavaTutorial/static/img/";
            String textToDisplay = "<html><div><img src=\"" + directoryLoc;

            if(e.getSource() == getResultBut) {
                System.out.println("Button pressed");

                if(extravertRadio.isSelected()) pageToOpen += "E";
                if(introvertRadio.isSelected()) pageToOpen += "I";

                if(sensorRadio.isSelected()) pageToOpen += "S";
                if(intuitiveRadio.isSelected()) pageToOpen += "N";

                if(feelerRadio.isSelected()) pageToOpen += "F";
                if(thinkerRadio.isSelected()) pageToOpen += "T";

                if(judgingRadio.isSelected()) pageToOpen += "J";
                if(perceivingRadio.isSelected()) pageToOpen += "P";

                thePanel.remove(ques1Panel);
                thePanel.remove(ques2Panel);
                thePanel.remove(ques3Panel);
                thePanel.remove(ques4Panel);

                textToDisplay += pageToOpen + ".jpg" + "\"></html>";

                yourReport = new JEditorPane("text/html", textToDisplay);
                yourReport.setEditable(false);
                yourReport.setSize(650, 825);

                JScrollPane scroller = new JScrollPane(
                        yourReport,
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
                );
                scroller.setPreferredSize(new Dimension(650, 825));
                thePanel.add(scroller);
                getResultBut.setVisible(false);

                thePanel.revalidate();
                thePanel.repaint();
            }

        }
    }

}
