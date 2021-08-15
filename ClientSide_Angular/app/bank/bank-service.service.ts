import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Bank } from './bank-data';

@Injectable({
  providedIn: 'root'
})
export class BankService {
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  private url = "http://localhost:8080/BankProject/admin/bank";
  
  constructor(private _httpClient: HttpClient) { }
  
  // Bank List
  getBanks(): Observable<Bank[]> {
    return this._httpClient.get<Bank[]>(this.url);
  }

  addBank(bank: Bank): Observable<Bank> {
    return this._httpClient.post<Bank>(`${this.url}/add`, bank, this.httpOptions);
  }

  updateBank(bank: Bank): Observable<Bank> {
    return this._httpClient.put<Bank>(`${this.url}/${bank.bankCode}`, JSON.stringify(bank), this.httpOptions);
  }

  getBankByCode(bankCode: string): Observable<Bank> {
    return this._httpClient.get<Bank>(`${this.url}/${bankCode}`);
  }
}
