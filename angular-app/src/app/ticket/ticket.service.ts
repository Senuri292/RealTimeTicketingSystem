import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TicketService {
  private apiUrl = 'http://localhost:4200/api/tickets';

  constructor(private http: HttpClient) {}

  getTickets(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  createTicket(ticket: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, ticket);
  }
}
