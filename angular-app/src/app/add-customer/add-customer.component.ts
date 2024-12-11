import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import ApiService from '../api.service';
import axios from 'axios';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  standalone: true,
  imports: [
    FormsModule
  ],
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent {
  customerId: number  = 0;
  customerName: string = '';
  numOfTickets: number  = 0;
  private customerData: any;

  addCustomer() {
    // Logic to add a new vendor
    console.log('Vendor ID:', this.customerId);
    console.log('Vendor Name:', this.customerName);
    console.log('Number of Tickets Vendor have:', this.numOfTickets);

    ApiService.addVendor(this.customerData)
    return axios.post("http://localhost:8081/api/vendors", this.customerData)
      .then(response => {
        console.log('Vendor added successfully:', response.data);
      })
      .catch(error => {
        console.error('Error adding vendor:', error);
      });

    // Reset the form fields
    this.customerId = 0;
    this.customerName = '';
    this.numOfTickets = 0;
  }
}
