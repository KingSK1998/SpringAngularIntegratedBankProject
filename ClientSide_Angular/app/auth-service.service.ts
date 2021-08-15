import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { UserData } from './userData';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  url = "http://localhost:8080/BankProject/login";

  user!: UserData;

  constructor(private _httpClient: HttpClient) {
   }

  getUserDetails(data: UserData): Observable<UserData> {
    console.log("data: " + data);
    return this._httpClient.post<UserData>(`${this.url}/user`, data, this.httpOptions);
  }

  loggedUser(): Observable<UserData> {
    return this._httpClient.get<UserData>(`${this.url}/getUser`);
  }
}
