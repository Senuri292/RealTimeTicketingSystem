import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';
import axios from 'axios';

@Component({
  selector: 'app-add-vendor',
  templateUrl: './add-vendor.component.html',
  standalone: true,
  imports: [
    FormsModule,
    NgIf
  ],
  styleUrls: ['./add-vendor.component.css']
})
export class AddVendorComponent {
  vendorId: number = 0;
  vendorName: string = "";
  numOfTickets: number = 0;
  private vendorData: any;

  addVendor() {
    const customerData = {
      customerId: this.vendorId,
      customerName: this.vendorName,
      numOfTickets: this.numOfTickets
    };

    // Ensure Axios is configured with base URL if needed
    axios.defaults.baseURL = 'http://localhost:8081';

    axios.post("/api/vendors", this.vendorData)
      .then(response => {
        console.log('Vendor added successfully:', response.data);
        // Reset form fields
        this.vendorId = 0;
        this.vendorName = '';
        this.numOfTickets = 0;
      })
      .catch(error => {
        console.error('Error adding vendor:', error);
        if (error.response) {
          // The request was made and the server responded with a status code
          console.log(error.response.data);
          console.log(error.response.status);
        } else if (error.request) {
          // The request was made but no response was received
          console.log(error.request);
        } else {
          // Something happened in setting up the request
          console.log('Error', error.message);
        }
      });
  }
}
