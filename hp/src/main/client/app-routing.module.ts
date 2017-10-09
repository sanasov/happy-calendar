import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CalendarComponent} from "./component/calendar/calendar.component";
import {EventComponent} from "./component/event/event.category.component";
import {HolidayComponent} from "./component/holiday/holiday.component";
import {ProfileComponent} from "./component/profile/profile.component";
import {EventDetailComponent} from "./component/event/event-detail/event.category.detail.component";


const routes: Routes = [
    {path: '', redirectTo: '/', pathMatch: 'full'},
    {path: 'calendar', component: CalendarComponent},
    {
        path: 'event', component: EventComponent,
        children: [
            {path: ':id', component: EventDetailComponent}
        ]
    },
    {path: 'holiday', component: HolidayComponent},
    {path: 'profile', component: ProfileComponent},
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes, {useHash: true})
    ],
    exports: [
        RouterModule
    ]
})

export class AppRoutingModule {
}