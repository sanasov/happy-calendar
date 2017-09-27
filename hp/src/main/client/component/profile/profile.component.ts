import {Component} from '@angular/core';

@Component({
    selector: 'app-profile',
    templateUrl: './profile.component.html',
})
export class ProfileComponent {
    private fisrtname: string;

    constructor() {
        this.fisrtname = "Sergey";
    }
}