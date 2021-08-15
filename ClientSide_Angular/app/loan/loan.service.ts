import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Loan } from './loan-data';

@Injectable({
  providedIn: 'root'
})
export class LoanService {
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  private url = "http://localhost:8080/BankProject/manager/loan";
  
  constructor(private _httpClient: HttpClient) { }
  
  // Customer List
  getLoan(): Observable<Loan[]> {
    return this._httpClient.get<Loan[]>(this.url);
  }

  addLoan(loan: Loan): Observable<Loan> {
    return this._httpClient.post<Loan>(`${this.url}/add`, loan, this.httpOptions);
  }

  updateLoan(loan: Loan): Observable<Loan> {
    return this._httpClient.put<Loan>(`${this.url}/${loan.loanId}`, JSON.stringify(loan), this.httpOptions);
  }

  getLoanById(loanId: string): Observable<Loan> {
    return this._httpClient.get<Loan>(`${this.url}/${loanId}`);
  }
}
