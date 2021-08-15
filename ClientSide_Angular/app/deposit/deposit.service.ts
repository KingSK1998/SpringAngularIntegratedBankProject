import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Deposit } from './deposit-data';

@Injectable({
  providedIn: 'root'
})
export class DepositService {
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  private url = "http://localhost:8080/BankProject/clerk/deposit";
  
  constructor(private _httpClient: HttpClient) { }
  
  // Customer List
  getDeposit(): Observable<Deposit[]> {
    return this._httpClient.get<Deposit[]>(this.url);
  }

  addDeposit(deposit: Deposit): Observable<Deposit> {
    return this._httpClient.post<Deposit>(`${this.url}/add`, deposit, this.httpOptions);
  }

  updateDeposit(deposit: Deposit): Observable<Deposit> {
    return this._httpClient.put<Deposit>(`${this.url}/${deposit.depositId}`, JSON.stringify(deposit), this.httpOptions);
  }

  getDepositById(depositId: string): Observable<Deposit> {
    return this._httpClient.get<Deposit>(`${this.url}/${depositId}`);
  }
}
