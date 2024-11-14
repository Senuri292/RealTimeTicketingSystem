package com.example.RealTimeTicketingSystem;

public class Vendor {
    private String vendorName;
    private String eventName;
    private long vendorId;

    public Vendor(String vendorName, long vendorId) {
        this.vendorName = vendorName;
        this.vendorId = vendorId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public void addVendor() {}

    public void viewVendors () {
        //give a return type maybe a list
    }

    public void updateVendor(long vendorID) {}

    public void deleteVendor(long vendorID) {}


}
