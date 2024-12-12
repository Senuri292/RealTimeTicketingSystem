import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';
import axios from 'axios';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  standalone: true,
  imports: [
    FormsModule,
    NgIf
  ],
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent {
  customerId: number = 0;
  customerName: string = '';
  numOfTickets: number = 0;

  addCustomer() {
    const customerData = {
      customerId: this.customerId,
      customerName: this.customerName,
      numOfTickets: this.numOfTickets
    };

    // Ensure Axios is configured with base URL if needed
    axios.defaults.baseURL = 'http://localhost:8081';

    axios.post("/api/customers", customerData)
      .then(response => {
        console.log('Customer added successfully:', response.data);
        // Reset form fields
        this.customerId = 0;
        this.customerName = '';
        this.numOfTickets = 0;
      })
      .catch(error => {
        console.error('Error adding customer:', error);
        // Optional: Handle error (show message to user, etc.)
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
