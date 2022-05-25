import java.io.*;
import java.nio.Buffer;

public class Lesson32 {
    public static void main(String[] args) {
        Customer[] customers = getCustomers();
        // use to write characters to a file
        // if customers.txt is not exists it gonna create it otherwise override the previous file
        PrintWriter custOutput = createFile("C:\\Users\\vipin sharma\\Documents\\Java\\custom.txt");
        for(Customer person: customers) {
            createCustomers(person, custOutput);
        }

        custOutput.close();
        getFileInfo();
    }
    private static class Customer {
        public String firstName, lastName;
        public int customerAge;
        public Customer(String firstName, String lastName, int customerAge) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.customerAge = customerAge;
        }
    }
    private static Customer[] getCustomers() {
        Customer[] customers = new Customer[5];
        customers[0] = new Customer("John", "Smith", 21);
        customers[1] = new Customer("Sally", "Smith", 21);
        customers[2] = new Customer("Ritika", "Smith", 21);
        customers[3] = new Customer("Tom", "Smith", 21);
        customers[4] = new Customer("Mark", "Smith", 21);
        return customers;
    }
    private static PrintWriter createFile(String fileName) {
        try {
            File listOfNames = new File(fileName);
            // BufferedWriter -> gather a bunch of characters and write them all at one time
            // FileWriter-> use to write stream of characters to a file
            PrintWriter infoToWrite = new PrintWriter(new BufferedWriter(new FileWriter(listOfNames)));
            return infoToWrite;
        }
        catch(IOException e) {
            System.out.println("An IO Error occured");
            System.exit(0);
        }
        return null;
    }
    private static void createCustomers(Customer customer, PrintWriter custOutput) {
        String customerInfo = customer.firstName + " " + customer.lastName + " ";
        customerInfo += Integer.toString(customer.customerAge);

        custOutput.println(customerInfo+"Is Mad");
    }
    private static void getFileInfo() {
        System.out.println("Info Written to File\n");
        File listOfNames = new File("C:\\Users\\vipin sharma\\Documents\\Java\\customers.txt");

        try {
            BufferedReader getInfo = new BufferedReader(new FileReader(listOfNames));

            // readLine(0 only reads one line at a time
            // and when we reach the end of the file the last thing that gonna sent to readLine method is null
            String customerInfo = getInfo.readLine();
            while(customerInfo != null) {

//                System.out.println(customerInfo);
                String[] indivCustomerData = customerInfo.split(" ");
                int customerAge = Integer.parseInt(indivCustomerData[2]);
                System.out.println("Customer " + indivCustomerData[0] + " is " + customerAge + "Years Old\n");
                customerInfo = getInfo.readLine();


            }
            System.out.println("This is a try Block");
        }
        catch(FileNotFoundException e) {
            System.out.println("File Not Found");

        }
        catch(IOException e) {
            System.out.println("An IO Error Occured");
        }

    }
}