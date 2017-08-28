import {Component, ViewChild} from '@angular/core';
import {MdDatepicker} from "@angular/material";

@Component({
    selector: 'app-calendar',
    templateUrl: './calendar.component.html',
})
export class CalendarComponent {
    private fisrtname: string;
    @ViewChild(MdDatepicker) datepicker: MdDatepicker<Date>;

    constructor() {
        this.fisrtname = "Sergey";
    }
}