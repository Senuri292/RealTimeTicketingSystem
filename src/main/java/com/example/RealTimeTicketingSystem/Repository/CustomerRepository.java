package com.example.RealTimeTicketingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.RealTimeTicketingSystem.threads.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
