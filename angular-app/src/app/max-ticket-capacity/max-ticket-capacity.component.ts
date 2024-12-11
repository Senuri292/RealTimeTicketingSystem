import { Component, Input } from '@angular/core';

@Component({
    selector: 'app-max-ticket-capacity',
    templateUrl: './max-ticket-capacity.component.html',
    standalone: true,
    styleUrls: ['./max-ticket-capacity.component.css']
})
export class MaxTicketCapacityComponent {
    @Input() maxTicketCapacity: number = 100;
}
