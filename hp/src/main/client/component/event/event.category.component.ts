import {Component} from '@angular/core';
import {EventService} from "../../service/EventService";
import {CategoryEvent} from "../../domain/CategoryEvent";
import {MdDialog} from "@angular/material";
import {EventCategoryAddDialog} from "./event.category.add.dialog";
import {Router} from "@angular/router";

@Component({
    selector: 'app-event-category',
    templateUrl: './event.category.component.html',
    styleUrls: ['./event.component.scss']
})
export class EventComponent {
    private categoryEvents: Array<CategoryEvent>;


    constructor(private eventService: EventService, private dialog: MdDialog, private router: Router) {
        eventService.categoryEvents().then(categoryEventsResult => {
            this.categoryEvents = categoryEventsResult
        });
    }

    open(category: CategoryEvent): void {
        const EVENT_CATEGORY_ROUTER = "event/";
        this.router.navigate([EVENT_CATEGORY_ROUTER + '/' + category.id]);
    }

    add(): void {
        let category: CategoryEvent = new CategoryEvent();

        let dialogRef = this.dialog.open(EventCategoryAddDialog, {
            width: '350px',
            data: category
        });

        dialogRef.afterClosed().subscribe(createdCategoryResult => {
            console.log('The dialog was closed');
            if (createdCategoryResult && createdCategoryResult.title) {
                this.eventService.save(createdCategoryResult).then(savedCategory => {
                    this.categoryEvents.push(savedCategory);
                });
            }
        });
    }
}
