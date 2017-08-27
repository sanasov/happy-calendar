import {Component} from '@angular/core';

@Component({
    selector: 'app-holiday',
    templateUrl: './holiday.component.html',
})
export class HolidayComponent {
    private fisrtname: string;

    constructor() {
        this.fisrtname = "Sergey";
    }
}