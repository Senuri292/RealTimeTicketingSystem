package com.example.RealTimeTicketingSystem.Service;

import com.example.RealTimeTicketingSystem.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.RealTimeTicketingSystem.threads.Vendor;
import java.util.List;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;
    // get details of existing vendors
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }
    // add new vendor to repository
    public Vendor addVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }
}
