import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {AppComponent} from "./component/AppComponent";
import {NavComponent} from "./component/nav/nav.component";
import {AppRoutingModule} from "./app-routing.module";
import {EventComponent} from "./component/event/event.component";
import {CalendarComponent} from "./component/calendar/calendar.component";
import {HolidayComponent} from "./component/holiday/holiday.component";
import {MaterialModule} from "./material.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {EventService} from "./service/EventService";


@NgModule({
    declarations: [
        AppComponent,
        NavComponent,
        CalendarComponent,
        EventComponent,
        HolidayComponent
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        FormsModule,
        HttpModule,
        AppRoutingModule,
        MaterialModule
    ],
    providers: [EventService],
    bootstrap: [AppComponent]
})
export class AppModule {
}