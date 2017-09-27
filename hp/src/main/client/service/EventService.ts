import {Headers, Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';


import {Injectable} from "@angular/core";
import {CategoryEvent} from "../domain/CategoryEvent";


@Injectable()

export class EventService {

    constructor(private http: Http) {

    }

    private headers = new Headers({'Content-Type': 'application/json'});
    private categoryEventUrl = 'event/all-categories';

    categoryEvents(): Promise<CategoryEvent[]> {
        return this.http.get(this.categoryEventUrl)
            .toPromise()
            .then(response => {
                return response.json()
            })
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
    // createBike(bike: Bike): Promise<Bike> {
    //     return this.http
    //         .post(this.bikesUrl, JSON.stringify(bike), { headers: this.headers })
    //         .toPromise()
    //         .then(res => res.json().data as Bike)
    //         .catch(this.handleError);
    // }
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