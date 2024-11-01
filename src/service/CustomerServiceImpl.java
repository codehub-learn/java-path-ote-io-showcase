package service;

import model.Customer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<Customer> readCustomersFromFile(String path) {
        try {
            List<Customer> customerList = new ArrayList<>();
            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);
            bufferedReader.readLine();
            String customerAsString;
            while ((customerAsString = bufferedReader.readLine()) != null) {
                String[] splitCustomer = customerAsString.split(",");
                customerList.add(new Customer(
                        Long.parseLong(splitCustomer[0]),
                        splitCustomer[1] + " " + splitCustomer[2],
                        splitCustomer[3])
                );
            }
            return customerList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeCustomersToFile(List<Customer> customers, String path) {

    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public List<Customer> getCustomers() {
        return List.of();
    }
}
