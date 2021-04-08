import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Dungeon } from './dungeon.model';

@Injectable()
export class DungeonGeneratorService {
    //move to some config file
    apiUrl = "https://dungeon-generator-backend.herokuapp.com/generator";
    constructor(private http: HttpClient) { }

    getGeneratedGrid(): Observable<Dungeon> {
        return this.http.get<Dungeon>(this.apiUrl);
    }
}