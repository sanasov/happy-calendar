import {Component} from '@angular/core';
import {EventService} from "../../service/EventService";
import {CategoryEvent} from "../../domain/CategoryEvent";

@Component({
    selector: 'app-event',
    templateUrl: './event.component.html',
    styleUrls: ['./event.component.scss']
})
export class EventComponent {
    private categoryEvents: Array<CategoryEvent>;

    constructor(private eventService: EventService) {
        eventService.categoryEvents().then(categoryEventsResult => {
            this.categoryEvents = categoryEventsResult
        });
    }
}