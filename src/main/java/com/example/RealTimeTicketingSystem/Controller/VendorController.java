package com.example.RealTimeTicketingSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.RealTimeTicketingSystem.Service.VendorService;
import com.example.RealTimeTicketingSystem.threads.Vendor;

import java.util.List;

// mapping VendorController class
@RestController
@RequestMapping("/api/vendors")
@CrossOrigin(origins = "http://localhost:4200")
public class VendorController {
    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @PutMapping
    public ResponseEntity<Vendor> addVendor(@RequestBody Vendor vendor) {
        Vendor savedVendor = vendorService.addVendor(vendor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVendor);
    }
}

