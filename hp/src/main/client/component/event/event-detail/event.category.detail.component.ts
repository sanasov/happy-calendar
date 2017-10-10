import {Component, OnInit} from '@angular/core';
import {MdDialog} from "@angular/material";
import {ActivatedRoute} from "@angular/router";
import {EventService} from "../../../service/EventService";
import {CategoryEvent} from "../../../domain/CategoryEvent";

@Component({
    selector: 'app-event-detail',
    templateUrl: './event.category.detail.component.html',
    styleUrls: []
})
export class EventDetailComponent implements OnInit {

    private categoryEvent: CategoryEvent;

    constructor(private eventService: EventService, private dialog: MdDialog, private activatedRoute: ActivatedRoute) {

    }

    ngOnInit() {
        this.activatedRoute.params.subscribe((params: any) => {
            if (params['id']) {
                this.eventService.categoryEvent(params['id']).then(res => this.categoryEvent = res);
            }
        });
    }

    open(category: CategoryEvent): void {
      alert("open");
    }

    add(): void {

    }

}
