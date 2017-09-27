import {HappyEvent} from "./HappyEvent";

export class CategoryEvent {
    id: number;
    title: String;
    description: String;
    events: Array<HappyEvent>;
}