import java.io.*;

public class Lesson33 {
    public static void main(String[] args) {
        Customer[] customers = getCustomers();

        // DataOutputStream allows you to do print primitive data types
        // to a file ( whenever you working with binary streams
        // the data type is very important

        DataOutputStream custOutput = createFile("C:\\Users\\vipin sharma\\Documents\\Java\\customers.odt");
        for(Customer person : customers) {
            createCustomers(person, custOutput);
        }
        try {
            custOutput.close();
        }
        catch(IOException e) {
            System.out.println("I/O Error");
            System.exit(0);
        }

        getFileInfo();

    } // END OF MAIN
    private static class Customer {
        public String custName;
        public int custAge;
        public double custDebt;
        public boolean oweMoney;
        public char custSex;

        public Customer(String custName, int custAge, double custDebt, boolean oweMoney, char custSex) {
            this.custName = custName;
            this.custAge = custAge;
            this.custDebt = custDebt;
            this.oweMoney = oweMoney;
            this.custSex = custSex;
        } // END OF CUSTOMER CONSTRUCTOR
    } // END OF CUSTOMER CLASS

    private static Customer[] getCustomers() {
        Customer[] customers = new Customer[5];

        customers[0] = new Customer("John Smith", 21, 12.25, true, 'M');
        customers[1] = new Customer("Paul Smith", 21, 12.25, true, 'M');
        customers[2] = new Customer("Sue Smith", 21, 12.25, true, 'M');
        customers[3] = new Customer("Sally Smith", 21, 12.25, true, 'M');
        customers[4] = new Customer("Mark Smith", 21, 12.25, true, 'M');

        return customers;
    } // END OF getCustomers

    private static DataOutputStream createFile(String fileName) {
        try {
            File listOfNames = new File(fileName);
            DataOutputStream infoToWrite = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(listOfNames)));
            return infoToWrite;
        }
        catch(IOException e) {
            System.out.println("IO Exception Occured");
            System.exit(0);
        }
        return null;
    } // END OF createFile

    private static void createCustomers(Customer customers, DataOutputStream custOutput) {
        try {
            // the method for inserting primitive data types are slightly different
            // It is not hard to remember
            custOutput.writeUTF(customers.custName);
            custOutput.writeInt(customers.custAge);
            custOutput.writeDouble(customers.custDebt);
            custOutput.writeBoolean(customers.oweMoney);
            custOutput.writeChar(customers.custSex);
            // writeByte, writeFloat, writeLong, writeShort
        }
        catch(IOException e) {
            System.out.println("IO Error Occured");
        }
    } // END OF createCustomers

    private static void getFileInfo() {
        System.out.println("Info Written ito File");
        File listOfNames = new File("C:\\Users\\vipin sharma\\Documents\\Java\\customers.odt");
        boolean eof = false;
        try {
            DataInputStream getInfo = new DataInputStream(new BufferedInputStream(new FileInputStream(listOfNames)));
            while(!eof) {
                String custName = getInfo.readUTF();
                int custAge = getInfo.readInt();
                double custDebt = getInfo.readDouble();
                boolean oweMoney = getInfo.readBoolean();
                char custSex = getInfo.readChar();

                System.out.println(custName);
                System.out.println(custAge);
                System.out.println(custDebt);
                System.out.println(oweMoney);
                System.out.println(custSex);
            }
        } // END OF TRY
        catch(EOFException e) {
            eof = true;
        }
        catch(FileNotFoundException e) {
            System.out.println("No File Found");
            System.exit(0);
        }
        catch(IOException e) {
            System.out.println("I/O Error Occured");
            System.exit(0);
        }

    } // END OF getFileInfo

} // END OF CLASS LESSON33
