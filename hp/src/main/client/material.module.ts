import {
    MdAutocompleteModule,
    MdButtonModule,
    MdCardModule,
    MdDialogModule,
    MdGridListModule,
    MdIconModule,
    MdInputModule,
    MdListModule,
    MdMenuModule,
    MdProgressBarModule,
    MdProgressSpinnerModule,
    MdSliderModule,
    MdSnackBarModule,
    MdTooltipModule,
    MdDatepickerModule, MdNativeDateModule
} from '@angular/material';
import {NgModule} from '@angular/core';

@NgModule({
    imports: [
        MdButtonModule,
        MdMenuModule,
        MdIconModule,
        MdCardModule,
        MdSliderModule,
        MdProgressBarModule,
        MdAutocompleteModule,
        MdInputModule,
        MdGridListModule,
        MdSnackBarModule,
        MdProgressSpinnerModule,
        MdTooltipModule,
        MdListModule,
        MdDialogModule,

        MdDatepickerModule, MdNativeDateModule

    ],
    exports: [
        MdButtonModule,
        MdMenuModule,
        MdIconModule,
        MdCardModule,
        MdSliderModule,
        MdProgressBarModule,
        MdAutocompleteModule,
        MdInputModule,
        MdGridListModule,
        MdSnackBarModule,
        MdProgressSpinnerModule,
        MdTooltipModule,
        MdListModule,
        MdDialogModule,

        MdDatepickerModule, MdNativeDateModule
    ],
})

export class MaterialModule {
}