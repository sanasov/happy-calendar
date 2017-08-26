import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {LoginComponent} from "./component/LoginComponent";


@NgModule({
    declarations: [
        LoginComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule
    ],
    entryComponents: [
        LoginComponent
    ],
    providers: [],
    bootstrap: [LoginComponent]
})
export class LoginModule {
}