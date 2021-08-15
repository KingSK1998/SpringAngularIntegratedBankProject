import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from './account-data';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  private url = "http://localhost:8080/BankProject/clerk/account";
  
  constructor(private _httpClient: HttpClient) { }
  
  // Account List
  getAccounts(): Observable<Account[]> {
    return this._httpClient.get<Account[]>(this.url);
  }

  addAccount(account: Account): Observable<Account> {
    return this._httpClient.post<Account>(`${this.url}/add`, account, this.httpOptions);
  }

  getAccountByNumber(accountNo: string): Observable<Account> {
    return this._httpClient.get<Account>(`${this.url}/${accountNo}`);
  }
}
