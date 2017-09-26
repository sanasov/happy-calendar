import {Component, ViewChild} from '@angular/core';
import {MdDatepicker} from "@angular/material";

@Component({
    selector: 'app-calendar',
    templateUrl: './calendar.component.html',
})
export class CalendarComponent {
    private fisrtname: string;
     private title: string;
    constructor() {
        this.fisrtname = "Sergey";
        this.title = "Hello";
    }

    onBlur() {
        alert(this.title);
    }
}