import { Routes } from '@angular/router';
import { TicketListComponent } from './ticket/ticket-list/ticket-list.component';
import { TicketDetailComponent } from './ticket-detail/ticket-detail.component';
import { CreateTicketComponent } from './create-ticket/create-ticket.component';

export const routes: Routes = [
  { path: 'tickets', component: TicketListComponent },
  { path: 'ticket/:id', component: TicketDetailComponent },
  { path: 'create-ticket', component: CreateTicketComponent },
  { path: '', redirectTo: '/tickets', pathMatch: 'full' }
];
