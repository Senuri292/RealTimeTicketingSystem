import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {NgIf} from '@angular/common';
import axios from 'axios';

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
  numTickets: number = 0;
  releaseRate: number = 0;
  retrievalRate: number = 0;
  maxTicketCapacity: number = 0;

  startTicketSystem() {
    // Ensure the payload matches the TicketRequest DTO in the backend
    axios.post('http://localhost:8081/api/tickets/start/start', {
      numTickets: this.numTickets,
      releaseRate: this.releaseRate,
      retrievalRate: this.retrievalRate,
      maxTicketCapacity: this.maxTicketCapacity
    }, {
    })
      .then(
        (response) => {
          console.log('Ticket system started:', response);
          // Handle the response from the backend
        },
        (error) => {
          console.error('Error starting ticket system:', error);
          // Handle any errors
        }
      );
  }
}
