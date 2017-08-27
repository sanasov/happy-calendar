import {Component} from '@angular/core';

@Component({
    selector: 'app-calendar',
    templateUrl: './calendar.component.html',
})
export class CalendarComponent {
    private fisrtname: string;

    constructor() {
        this.fisrtname = "Sergey";
    }
}