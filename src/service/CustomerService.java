package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> readCustomersFromFile(String path);
    void writeCustomersToFile(List<Customer> customers, String path);
    void addCustomer(Customer customer);
    List<Customer> getCustomers();
}
