package com.example.RealTimeTicketingSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.RealTimeTicketingSystem.threads.Customer;
import com.example.RealTimeTicketingSystem.Service.CustomerService;

import java.util.List;

//mapping CustomerController class
@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer savedVendor = customerService.addCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVendor);
    }
}
