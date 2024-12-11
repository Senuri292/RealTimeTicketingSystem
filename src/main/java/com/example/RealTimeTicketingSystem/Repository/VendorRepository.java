package com.example.RealTimeTicketingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.RealTimeTicketingSystem.threads.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
}
