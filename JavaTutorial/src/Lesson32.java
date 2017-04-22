import java.io.*;
import java.util.Arrays;


public class Lesson32 {

    public static void main(String[] args) {

        Customer[] customers = getCustomers();
        PrintWriter customerOutput = createFile("customers.txt");

        for(Customer person: customers) {
            createCustomers(person, customerOutput);
        }

        customerOutput.close();

        getFileInfo();

    } // END OF main

    private static class Customer {

        public String firstName, lastName;
        public int customerAge;

        public Customer(String firstName, String lastName, int customerAge) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.customerAge = customerAge;
        } // END OF Customer CONSTRUCTOR

    } // END OF Customer CLASS

    private static void createCustomers(Customer customer, PrintWriter customerOutput) {
        String custInfo = customer.firstName + " " + customer.lastName + " ";
        custInfo += Integer.toString(customer.customerAge);
        try {
            customerOutput.println(custInfo);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    } // END OF createCustomer METHOD

    private static Customer[] getCustomers() {
        Customer[] customers = new Customer[5];
        customers[0] = new Customer("John", "Smith", 21);
        customers[1] = new Customer("Sally", "Smith", 23);
        customers[2] = new Customer("Paul", "Smith", 25);
        customers[3] = new Customer("Tom", "Smith", 44);
        customers[4] = new Customer("Mark", "Smith", 38);

        return customers;
    } // END OF getCustomers METHOD

    private static PrintWriter createFile(String fileName) {
        try {
            File listOfNames = new File(fileName);
            PrintWriter infoToWrite = new PrintWriter(new BufferedWriter(new FileWriter(listOfNames)));
            return infoToWrite;
        } catch (IOException e) {
            System.out.println("An I/O Error Occurred: " + e);
            System.exit(0);
        }
        return null;
    }

    private static void getFileInfo() {
        System.out.println("Info Written to File\n");
        File listOfNames = new File("customers.txt");

        try {
            BufferedReader getInfo = new BufferedReader(new FileReader(listOfNames));
            String customerInfo = getInfo.readLine();

            while (customerInfo != null) {
//                System.out.println(customerInfo);
                String[] indivCustData = customerInfo.split(" ");
                int custAge = Integer.parseInt(indivCustData[2]);

                System.out.print("Customer: " + indivCustData[0] + " is " + custAge + "\n");

                customerInfo = getInfo.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(0);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        }
    }

} // END OF Lesson32 CLASS
