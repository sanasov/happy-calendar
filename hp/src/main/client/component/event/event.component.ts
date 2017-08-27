import {Component} from '@angular/core';

@Component({
    selector: 'app-event',
    templateUrl: './event.component.html',
})
export class EventComponent {
    private fisrtname: string;

    constructor() {
        this.fisrtname = "Sergey";
    }
}