import { Component} from '@angular/core';
import {NavigationBarComponent} from './navigation-bar/navigation-bar.component';
import {TotalTicketsComponent} from './total-tickets/total-tickets.component';
import {MaxTicketCapacityComponent} from './max-ticket-capacity/max-ticket-capacity.component';
import {StartStopComponent} from './start-stop/start-stop.component';
import {RouterOutlet} from '@angular/router';
import {AddCustomerComponent} from './add-customer/add-customer.component';
import {AddVendorComponent} from './add-vendor/add-vendor.component';


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
}


