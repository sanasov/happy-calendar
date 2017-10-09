import {Component} from '@angular/core';
import {MdDialog} from "@angular/material";
import {ActivatedRoute} from "@angular/router";
import {EventService} from "../../../service/EventService";
import {CategoryEvent} from "../../../domain/CategoryEvent";

@Component({
    selector: 'app-event-category-detail',
    templateUrl: './event.category.detail.component.html',
    styleUrls: []
})
export class EventDetailComponent {

    private categoryEvent: CategoryEvent;

    constructor(private eventService: EventService, private dialog: MdDialog, private activatedRoute: ActivatedRoute) {
        this.activatedRoute.params.subscribe((params: any) => {
            if (params['id']) {
                eventService.categoryEvent(params['id']).then(res => this.categoryEvent = res);
            }
        });
    }

    open(category: CategoryEvent): void {
      alert("open");
    }

    add(): void {

    }

}
