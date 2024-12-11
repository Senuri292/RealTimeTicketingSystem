package com.example.RealTimeTicketingSystem.Service;

import com.example.RealTimeTicketingSystem.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.RealTimeTicketingSystem.threads.Customer;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    // get details of existing customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    // add new customer to repository
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
