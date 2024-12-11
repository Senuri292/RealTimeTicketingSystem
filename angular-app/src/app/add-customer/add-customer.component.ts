import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';

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

  addCustomer() {
    // Logic to add a new vendor
    console.log('Vendor ID:', this.customerId);
    console.log('Vendor Name:', this.customerName);
    console.log('Number of Tickets Vendor have:', this.numOfTickets);

    // Reset the form fields

    this.customerId = 0;
    this.customerName = '';
    this.numOfTickets = 0;
  }
}
