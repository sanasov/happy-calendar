import {Component, Inject} from "@angular/core";
import {MD_DIALOG_DATA, MdDialogRef} from "@angular/material";
import {CategoryEvent} from "../../domain/CategoryEvent";

@Component({
    selector: 'event-category-add-dialog',
    templateUrl: './event-category-add-dialog.html',
})
export class EventCategoryAddDialog {

    constructor(public dialogRef: MdDialogRef<EventCategoryAddDialog>,
                @Inject(MD_DIALOG_DATA) public data: CategoryEvent) {
    }

    onNoClick(): void {
        this.dialogRef.close();
    }

}