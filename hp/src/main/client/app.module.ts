import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
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
import {ProfileComponent} from "./component/profile/profile.component";
import {EventCategoryAddDialog} from "./component/event/event.category.add.dialog";



@NgModule({
    declarations: [
        AppComponent,
        NavComponent,
        CalendarComponent,
        EventComponent,
        HolidayComponent,
        ProfileComponent,
        EventCategoryAddDialog
    ],
    entryComponents: [EventCategoryAddDialog],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,

        FormsModule,
        ReactiveFormsModule,

        HttpModule,
        AppRoutingModule,
        MaterialModule,
    ],
    providers: [EventService],
    bootstrap: [AppComponent]
})
export class AppModule {
}