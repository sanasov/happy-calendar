import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CalendarComponent} from "./component/calendar/calendar.component";
import {EventComponent} from "./component/event/event.component";
import {HolidayComponent} from "./component/holiday/holiday.component";


const routes: Routes = [
    {path: '', redirectTo: '/', pathMatch: 'full'},
    {path: 'calendar', component: CalendarComponent},
    {path: 'event', component: EventComponent},
    {path: 'holiday', component: HolidayComponent},
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes, { useHash: true })
    ],
    exports: [
        RouterModule
    ]
})

export class AppRoutingModule {
}