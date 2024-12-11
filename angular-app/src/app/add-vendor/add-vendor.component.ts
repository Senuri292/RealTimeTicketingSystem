import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-add-vendor',
  templateUrl: './add-vendor.component.html',
  standalone: true,
  imports: [
    FormsModule
  ],
  styleUrls: ['./add-vendor.component.css']
})
export class AddVendorComponent {
  vendorId: number  = 0;
  vendorName: string = '';
  numOfTickets: number  = 0;

  addVendor() {
    // Logic to add a new vendor
    console.log('Vendor ID:', this.vendorId);
    console.log('Vendor Name:', this.vendorName);
    console.log('Number of Tickets Vendor have:', this.numOfTickets);

    // Reset the form fields

    this.vendorId = 0;
    this.vendorName = '';
    this.numOfTickets = 0;
  }
}
