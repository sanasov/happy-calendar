import {Component} from '@angular/core';

@Component({
    selector: 'app-component',
    templateUrl: './index-page.tpl.html'
})
export class AppComponent {
    private fisrtname: string;

    constructor() {
        this.fisrtname = "Sergey";
    }
}