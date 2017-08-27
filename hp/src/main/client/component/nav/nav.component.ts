import {Component} from '@angular/core';

@Component({
    selector: 'app-nav',
    templateUrl: './nav.component.html',
})
export class NavComponent {
    private fisrtname: string;

    constructor() {
        this.fisrtname = "Sergey";
    }
}