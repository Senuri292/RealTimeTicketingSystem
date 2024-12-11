import { Component} from '@angular/core';
import {NavigationBarComponent} from './navigation-bar/navigation-bar.component';
import {TotalTicketsComponent} from './total-tickets/total-tickets.component';
import {MaxTicketCapacityComponent} from './max-ticket-capacity/max-ticket-capacity.component';
import {StartStopComponent} from './start-stop/start-stop.component';
import {RouterOutlet} from '@angular/router';
import {AddCustomerComponent} from './add-customer/add-customer.component';
import {AddVendorComponent} from './add-vendor/add-vendor.component';
import ApiService from './api.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: true,
  imports: [
    NavigationBarComponent,
    TotalTicketsComponent,
    MaxTicketCapacityComponent,
    StartStopComponent,
    AddCustomerComponent,
    AddVendorComponent,
  ],
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  totalTickets: number = 50;
  maxTicketCapacity: number = 100;
  vendorData: any = {};
  customerData: any = {};
  title: string = 'Real-Time Ticketing System';

  addVendor() {
    ApiService.addVendor(this.vendorData)
      .then((response) => {
        console.log('Vendor added successfully');
      })
      .catch((error) => {
        console.error('Error adding vendor:', error);
      });
  }
  addCustomer() {
    ApiService.addCustomer(this.customerData)
      .then((response) => {
        console.log('Customer added successfully');
      })
      .catch((error) => {
        console.error('Error adding customer:', error);
      });
  }
}


