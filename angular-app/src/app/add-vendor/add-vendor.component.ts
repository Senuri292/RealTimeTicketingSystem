import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import ApiService from '../api.service';
import axios from 'axios';

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
  vendorId: number = 0;
  vendorName: string = "";
  numOfTickets: number = 0;
  private vendorData: any;

  addVendor() {
    // Logic to add a new vendor
    console.log('Vendor ID:', this.vendorId);
    console.log('Vendor Name:', this.vendorName);
    console.log('Number of Tickets Vendor have:', this.numOfTickets);

    ApiService.addVendor(this.vendorData)
      return axios.post("http://localhost:8081/api/vendors", this.vendorData)
        .then(response => {
          console.log('Vendor added successfully:', response.data);
        })
        .catch(error => {
          console.error('Error adding vendor:', error);
        });
    //Reset the form fields
    this.vendorId = 0;
    this.vendorName = '';
    this.numOfTickets = 0;
  }

}
