import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// The API for accessing and processing data stored in a database
import java.sql.*;
import java.text.ParseException;

// Allows you to convert from string to date or vice versa
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Lesson38 extends JFrame {
    static JLabel lFirstName, lLastName, lState, lBirthDate;
    static JTextField tfFirstName, tfLastName, tfState, tfBirthDate;
    static Date dateBirthDate, sqlBirthDate;
    static ResultSet rows;

    // Holds row values for the table
    static Object[][] databaseResults;

    // Holds column names for the table
    static Object[] columns = {"Id", "First Name", "Last Name", "State", "Birth Date"};

    // DefaultTableModel defines the methods JTable will use
    // I'm overriding the getColumnClass
    static DefaultTableModel dTableModel = new DefaultTableModel(databaseResults, columns) {
        public Class getColumnClass(int column) {
            Class returnValue;

            // Verifying that the column exists (index > 0 && index < number of columns)
            if((column >= 0) && (column < getColumnCount())) {
                returnValue = getValueAt(0, column).getClass();
            } else {
                // Returns the class for the item in the column
                returnValue = Object.class;
            }
            return returnValue;
        }
    };

    // Create a JTable using the custom DefaultTableModel
    static JTable table = new JTable(dTableModel);

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // A connection object is used to provide access to a database
        Connection conn = null;

        try {
            // The driver allows you to query the database with Java
            // forName dynamically loads the class for you
            Class.forName("com.mysql.jdbc.Driver");

            // DriveManager is used to handle a set of JDBC drivers
            // getConnection establishes a connection to the database
            // You must also pass the userid and password for the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/samp_db", "learn-java", "learn-java");

            // Statemtnt objects executes a SQL query
            // createStatement returns a Statement object
            Statement sqlState = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String query = "SELECT id, first_name, last_name, state, birth FROM president";

            // A ResultSet contains a table of data representing the
            // results of the query. It can not be changed and can
            // only be read in one direction
            rows = sqlState.executeQuery(query);

            // Temporarily holds the row results
            Object[] tempRow;

            // next is used to iterate through the results of a query
            while(rows.next()) {
                tempRow = new Object[] {
                        rows.getInt(1),
                        rows.getString(2),
                        rows.getString(3),
                        rows.getString(4),
                        rows.getDate(5)
                };

                dTableModel.addRow(tempRow);
            }

        } catch(SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            System.out.println("VendorError: " + e.getErrorCode());
//            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            // Executes if the driver can't be found
            e.printStackTrace();
        }

        // Increatse the forn size for the cells in the table
        table.setFont(new Font("Serif", Font.PLAIN, 16));

        // Increase the size of the cells to allow for bigger fonts
        table.setRowHeight(table.getRowHeight()+10);

        // Allows the user to sort the data
        table.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Creates a button that when pressed executes the code
        // in the method actionPerformed
        JButton addPres = new JButton("Add President");
        ListenForButton lForButton = new ListenForButton();
        addPres.addActionListener(lForButton);

        JButton removePres = new JButton("Remove President");
        removePres.addActionListener(lForButton);

        // Define values for my labels
        lFirstName = new JLabel("First Name");
        lLastName = new JLabel("Last Name");
        lState = new JLabel("State");
        lBirthDate = new JLabel("Birthday");

        // Define the size of text fields
        tfFirstName = new JTextField(15);
        tfLastName = new JTextField(15);
        tfState = new JTextField(2);

        // Set default text and size for text field
        tfBirthDate = new JTextField("yyyy-MM-dd", 10);

        // Create a panel to hold editing buttons and fields
        JPanel inputPanel = new JPanel();

        // Put components in the panel
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

        // Add the component panel to the frame
        frame.add(inputPanel, BorderLayout.SOUTH);

        // When the user click on a cell they'll be able to change the value
        table.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent me) {
                String value = JOptionPane.showInputDialog(null, "Enter Cell Value:");

                // Value changed only if OK is clicked
                if(value != null) {
                    table.setValueAt(value, table.getSelectedRow(), table.getSelectedColumn());
                    System.out.println(value);
                }

                String updateCol = "";

                try {
                    rows.absolute(table.getSelectedRow()+1);
                    updateCol = dTableModel.getColumnName(table.getSelectedColumn());
                    System.out.println(updateCol);

                    switch(updateCol) {
                        case "birth":
                            sqlBirthDate = getADate(value);
                            rows.updateDate(updateCol, (java.sql.Date) sqlBirthDate);
                            rows.updateRow();
                            break;

                        default:
                            rows.updateString(updateCol, value);
                            System.out.println(rows);
                            System.out.println("Current Row: " + rows.getRow());

                            rows.updateRow();
                    }

                } catch(SQLException e1) {
//                    e1.printStackTrace();
                }

            }
        });

        frame.setSize(1200, 800);
        frame.setVisible(true);
    } // END OF main

    private static class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());

            if(e.getActionCommand() == "Add President") {
                System.out.println("Add President: " + e.getSource());

                String sFirstName = "",
                        sLastName = "",
                        sState = "",
                        sDate = "";

                // getText returns the value in the text field
                sFirstName = tfFirstName.getText();
                sLastName = tfLastName.getText();
                sState = tfState.getText();
                sDate = tfBirthDate.getText();

                // Will conver from string to date
                sqlBirthDate = getADate(sDate);

                try {
                    rows.moveToInsertRow();

                    rows.updateString("first_name", sFirstName);
                    rows.updateString("last_name", sLastName);
                    rows.updateString("state", sState);
                    rows.updateDate("birth", (java.sql.Date) sqlBirthDate);

                    // To directly update dababase
                    rows.insertRow();
                    rows.updateRow();

                } catch(SQLException e1) {
                    e1.printStackTrace();
                }

                int id = 0;

                try {
                    rows.last();
                    id = rows.getInt(1);
                } catch(SQLException e1) {
                    e1.printStackTrace();
                }

                Object[] president = {id, sFirstName, sLastName, sState, sqlBirthDate};
                dTableModel.addRow(president);
            } else if(e.getActionCommand() == "Remove President") {
                System.out.println("Remove President: " + e.getSource());


                try {
                    rows.absolute(table.getSelectedRow()+1);
                    rows.deleteRow();
                    dTableModel.removeRow(table.getSelectedRow());
                } catch(SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    } // END OF ListenForButton CLASS

    public static java.util.Date getADate(String sDate) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            dateBirthDate = dateFormatter.parse(sDate);
            sqlBirthDate = new java.sql.Date(dateBirthDate.getTime());
        } catch(ParseException e) {
            e.printStackTrace();
        }

        return sqlBirthDate;
    } // END OF getADate METHOD

} // END OF Lesson38 CLASS
