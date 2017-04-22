import java.io.*;


public class Lesson33 {
    public static void main(String[] args) {

        Customer[] customers = getCustomers();
        DataOutputStream custOutput = createFile("customers.dat");

        for(Customer customer: customers) {
            createCustomers(customer, custOutput);
        }

        try {
            custOutput.close();
        } catch(IOException e) {
            System.out.println(e);
        }

        getFileInfo("customers.dat");

    } // END OF main

    private static class Customer {
        public String custName;
        public int custAge;
        public char custSex;
        public double custDebt;
        public boolean oweMoney;

        public Customer(String custName, int custAge, char custSex, double custDebt, boolean oweMoney) {
            this.custName = custName;
            this.custAge = custAge;
            this.custSex = custSex;
            this.custDebt = custDebt;
            this.oweMoney = oweMoney;
        } // END OF Customer CONSTRUCTOR

    } // END OF Customer CLASS

    private static Customer[] getCustomers() {
        Customer[] customers = new Customer[5];
        customers[0] = new Customer("John Smith", 21, 'M', 12.25, true);
        customers[1] = new Customer("Paul Smith", 25, 'M', 12.25, true);
        customers[2] = new Customer("Sue Smith", 28, 'F', 12.25, true);
        customers[3] = new Customer("Sally Smith", 33, 'F', 12.25, true);
        customers[4] = new Customer("Mark Smith", 45, 'M', 12.25, true);

        return customers;
    } // END OF getCustomers METHOD

    private static DataOutputStream createFile(String fileName) {
        try {
            File listOfNames = new File(fileName);

            DataOutputStream infoToWrite = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(listOfNames)));

            // Adding true inside FileOutputStream causes that new information will be appended to file
            // (file won't be overwritten)
            // FileOutputStream(listOfNames, true);

            return infoToWrite;
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        }

        return null;
    } // END OF createFile METHOD

    private static void getFileInfo(String fileName) {
        System.out.println("Info Written to File");

        File listOfNames = new File(fileName);

        boolean eof = false;

        try {
            DataInputStream getInfo = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(listOfNames)));
            while (!eof) {
                String custName = getInfo.readUTF();
                int custAge = getInfo.readInt();
                char custSex = getInfo.readChar();
                double custDebt = getInfo.readDouble();
                boolean custOweMoney = getInfo.readBoolean();

                System.out.printf("%s %d %c %.02f %b\n", custName, custAge, custSex, custDebt, custOweMoney);

            }
        } catch(EOFException e) {
            eof = true;
        } catch(FileNotFoundException e) {
            System.out.println(e);
            System.exit(0);
        } catch(IOException e) {
            System.out.println(e);
            System.exit(0);
        }
    } // END OF getFileInfo METHOD

    private static void createCustomers(Customer customer, DataOutputStream custOutput) {
        try {
            custOutput.writeUTF(customer.custName);
            custOutput.writeInt(customer.custAge);
            custOutput.writeChar(customer.custSex);
            custOutput.writeDouble(customer.custDebt);
            custOutput.writeBoolean(customer.oweMoney);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        }
    } // END OF createCustomers METHOD

} // END OF Lesson33 CLASS
