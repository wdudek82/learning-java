import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;
import java.text.ParseException;

import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Lesson37 extends JFrame {

    static JLabel lFirstName, lLastName, lState, lBirthDate;
    static JTextField tfFirstName, tfLastName, tfState, tfBirthDate;
    static java.util.Date dateBirthDate, sqlBirthDate;

    static Object[][] databaseResults;
    static Object[] columns = {"First Name", "Last Name", "State", "Birth Date"};

    // overiding DefaultTableModel class
    static DefaultTableModel dTableModel = new DefaultTableModel(databaseResults, columns) {
        // withoud that Java considers every data in JTable to be a String
        public Class getColumnClass(int column) {
            Class returnValue;

            if((column >= 0) && (column < getColumnCount())) {
                returnValue = getValueAt(0, column).getClass();
            } else {
                returnValue = Object.class;
            }

            return returnValue;
        }
    };

    static JTable table = new JTable(dTableModel);


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Connection conn = null;

        try {
            Class.forName("con.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/samp_db", "learn-java", "learn-java");

            Statement sqlState = conn.createStatement();
            String query = "SELECT first_name, last_name, state, birth FROM president";
            ResultSet rows = sqlState.executeQuery(query);

            Object[] tempRow;

            while(rows.next()) {
                // getInt, getFloat, getBoolean, ...
                tempRow = new Object[] { rows.getString(1), rows.getString(2), rows.getString(3), rows.getDate(4) };
                dTableModel.addRow(tempRow);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        table.setFont(new Font("Serif", Font.PLAIN, 16));
        table.setRowHeight(table.getRowHeight() + 16);

        table.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JButton addPres = new JButton("Add President");
        addPres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sFirstName="", sLastName="", sState="", sDate="";

                sFirstName = tfFirstName.getText();
                sLastName = tfLastName.getText();
                sState = tfState.getText();
                sDate = tfBirthDate.getText();

                SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    dateBirthDate = dateFormatter.parse(sDate);
                    sqlBirthDate = new java.sql.Date(dateBirthDate.getTime());
                } catch(ParseException ex) {
                    ex.printStackTrace();
                }

                Object[] president = {sFirstName, sLastName, sState, sqlBirthDate};
                dTableModel.addRow(president);
            }
        });

        JButton removePres = new JButton("Remove President");
        removePres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dTableModel.removeRow(table.getSelectedRow());
            }
        });

        lFirstName = new JLabel("First Name");
        lLastName = new JLabel("Last Name");
        lState = new JLabel("State");
        lBirthDate = new JLabel("Birth Date");

        tfFirstName = new JTextField(15);
        tfLastName = new JTextField(15);
        tfState = new JTextField(2);
        tfBirthDate = new JTextField("yyyy-MM-dd", 15);

        JPanel inputPanel = new JPanel();

        inputPanel.add(lFirstName);
        inputPanel.add(tfFirstName);
        inputPanel.add(lLastName);
        inputPanel.add(tfLastName);
        inputPanel.add(lState);
        inputPanel.add(tfState);
        inputPanel.add(lBirthDate);
        inputPanel.add(tfBirthDate);

        inputPanel.add(addPres);
        inputPanel.add(removePres);


        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setSize(1000, 800);
        frame.setVisible(true);
    } // END OF main

} // END OF Lesson37
