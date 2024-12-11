import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-start-stop',
  templateUrl: './start-stop.component.html',
  standalone: true,
  imports: [
    FormsModule,
    NgIf
  ],
  styleUrls: ['./start-stop.component.css']
})
export class StartStopComponent {
  showForm = false;
  totalTickets: number = 0;
  releaseRate: number = 0;
  retrievalRate: number = 0;
  maxCapacity: number = 0;

  submitForm() {
    // Handle form submission logic here
    console.log({
      totalTickets: this.totalTickets,
      releaseRate: this.releaseRate,
      retrievalRate: this.retrievalRate,
      maxCapacity: this.maxCapacity
    });
  }
}
