import { Component, OnInit } from '@angular/core';
import { TicketService } from './ticket/ticket.service';

@Component({
  selector: 'app-ticket-list',
  templateUrl: './ticket-list.component.html',
  standalone: true,
  styleUrls: ['./ticket-list.component.css']
})
export class AppComponent {
  title = 'RealTimeTicketingSystem';
}

export class TicketListComponent implements OnInit {
  tickets: any[] = [];

  constructor(private ticketService: TicketService) {}

  ngOnInit(): void {
    this.ticketService.getTickets().subscribe(
      (data) => {
        this.tickets = data;
      },
      (error) => {
        console.error('Error fetching tickets:', error);
      }
    );
  }
}
