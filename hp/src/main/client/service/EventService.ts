import {Headers, Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';


import {Injectable} from "@angular/core";
import {CategoryEvent} from "../domain/CategoryEvent";


@Injectable()

export class EventService {

    constructor(private http: Http) {

    }

    private headers = new Headers({'Content-Type': 'application/json'});
    private GET_ALL_CATEGORIES = 'event/all-categories';
    private SAVE_CATEGORY = 'event/save-category';

    categoryEvents(): Promise<CategoryEvent[]> {
        return this.http.get(this.GET_ALL_CATEGORIES)
            .toPromise()
            .then(response => response.json())
            .catch(this.handleError);
    }

    save(categoryEvent: CategoryEvent): Promise<CategoryEvent> {
        return this.http
            .post(this.SAVE_CATEGORY, JSON.stringify(categoryEvent), {headers: this.headers})
            .toPromise()
            .then(response => response.json())
            .catch(this.handleError);
    }

    //
    // getBike(id: number): Promise<Bike> {
    //     const url = `${this.bikesUrl}/${id}`;
    //     return this.http.get(url)
    //         .toPromise()
    //         .then(response => response.json().data as Bike)
    //         .catch(this.handleError);
    // }
    //
    //
    //
    // updateBike(bike: Bike): Promise<Bike> {
    //     const url = `${this.bikesUrl}/${bike.id}`;
    //     return this.http
    //         .put(url, JSON.stringify(bike), { headers: this.headers })
    //         .toPromise()
    //         .then(() => bike)
    //         .catch(this.handleError);
    // }
    //
    // deleteBike(bike: Bike): Promise<void> {
    //     const url = `${this.bikesUrl}/${bike.id}`;
    //     return this.http.delete(url, { headers: this.headers })
    //         .toPromise()
    //         .then(() => null)
    //         .catch(this.handleError);
    // }
    //
    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}