import model.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //writerMethod();
        //readerMethod();
        //fileClassMethod();
        /*String customerAsString = "1,Ioannis Daniil,3th Street Athens";
        String[] split = customerAsString.split(",");
        System.out.println(Arrays.toString(split));*/

        CustomerService customerService = new CustomerServiceImpl();
        List<Customer> customers = customerService.readCustomersFromFile("data/customers.csv");
        for (Customer customer : customers) {
            System.out.println(customer);
            customerService.addCustomer(customer);
        }
        customerService.addCustomer(new Customer(4, "Io Dio", "Ioannina 15"));
/*        Customer customer = customers.get(0);
        String[] fullnameArray = customer.getName().split(" ");
        String customerAsString = customer.getId() + "," + customer.getName() + "," + customer.getAddress();*/
        customerService.writeCustomersToFile(customerService.getCustomers(), "data/customers.csv");
    }

    private static void fileClassMethod() {
        File file = new File("readme.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.exists());

        File newFile = new File("readme4");
        newFile.mkdir();
        /*try {
            newFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        newFile.delete();
    }

    public static void writerMethod(){
        try {
            FileWriter writer = new FileWriter("readme.txt");
            writer.write("hello\n");
            writer.write("hello\n");
            writer.write("hello\n");
            writer.write("hello\n");
            writer.write("hello\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readerMethod(){
        try {
            FileReader reader = new FileReader("readme.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}