import com.sun.org.apache.xpath.internal.SourceTree;

import java.awt.event.*;
import java.awt.Dimension;
import java.util.Enumeration;
import javax.swing.*;
import javax.swing.tree.*;


public class Lesson27 extends JFrame {

    JButton button1;
    String outputString = "";

    JTree theTree;
    DefaultMutableTreeNode documents, code, java, django, bash, js, work, games, emails;
    DefaultMutableTreeNode fileSystem = new DefaultMutableTreeNode("home");

    public static void main(String[] args) {
        new Lesson27();
    }

    public Lesson27() {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Swing 8 - JTree");

        JPanel thePanel = new JPanel();

        button1 = new JButton("Get Answer");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        theTree = new JTree(fileSystem);
        theTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        theTree.setVisibleRowCount(8);

        documents = addAFile("Dosc", fileSystem);
        addAFile("Taxes.exl", documents);
        addAFile("Story.txt", documents);

        code = addAFile("code", fileSystem);
        django = addAFile("django", code);
        addAFile("mysandbox-backend-django", django);
        java = addAFile("java", code);
        js = addAFile("js", code);
        bash = addAFile("bash", code);

        emails = addAFile("Emails", documents);
        addAFile("Schedule.txt", emails);
        addAFile("CallBob.txt", emails);

        work = addAFile("Work Applications", fileSystem);
        addAFile("Spreadsheet.java", work);
        addAFile("LibreOffice.ico.", work);

        games = addAFile("Games", fileSystem);
        addAFile("Planescape Torment", games);
        addAFile("Diablo III", games);

//        thePanel.add(theTree);

        JScrollPane scrollPane = new JScrollPane(theTree);
        Dimension d = scrollPane.getPreferredSize();
        d.width = 200;
        scrollPane.setPreferredSize(d);
        thePanel.add(scrollPane);

        this.add(thePanel);
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                try {
                    Object treeObject = theTree.getLastSelectedPathComponent();
                    DefaultMutableTreeNode theFile = (DefaultMutableTreeNode) treeObject;
                    String treeNode = (String) theFile.getUserObject() + "\n";
                    outputString = treeNode;
                    outputString += "Number of Children: " + theFile.getChildCount() + "\n";
                    outputString += "Number of Siblings: " + theFile.getSiblingCount() + "\n";
                    outputString += "Parent: " + theFile.getParent() + "\n";
                    outputString += "Next Node: " + theFile.getNextNode() + "\n";
                    outputString += "Next Leaf: " + theFile.getNextLeaf() + "\n";
                    outputString += "\nChildren of Node: \n";

                    for(Enumeration enumValue = theFile.children(); enumValue.hasMoreElements(); ) {
                        outputString += enumValue.nextElement() + "\n";
                    }

                    outputString += "\nPath from root:\n";
                    TreeNode[] pathNodes = theFile.getPath();
                    for(TreeNode indivNodes: pathNodes) {
                        outputString += indivNodes + "/";
                    }
                } catch (NullPointerException ex) {
                    outputString = "Select a node";
                }

                System.out.println("Clicked: " + outputString);


                JOptionPane.showMessageDialog(Lesson27.this, outputString);
            }
        }
    }

    private DefaultMutableTreeNode addAFile(String fileName, DefaultMutableTreeNode parentFolder) {
        DefaultMutableTreeNode newFile = new DefaultMutableTreeNode(fileName);
        parentFolder.add(newFile);

        return newFile;
    }
}
