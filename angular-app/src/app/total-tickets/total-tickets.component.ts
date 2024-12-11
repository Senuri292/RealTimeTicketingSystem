import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-total-tickets',
  templateUrl: './total-tickets.component.html',
  standalone: true,
  styleUrls: ['./total-tickets.component.css']
})
export class TotalTicketsComponent {
  @Input() totalTickets: number = 50;
}
