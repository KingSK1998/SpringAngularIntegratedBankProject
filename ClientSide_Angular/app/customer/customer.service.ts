import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from './customer-data';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  private url = "http://localhost:8080/BankProject/clerk/customer";
  
  constructor(private _httpClient: HttpClient) { }
  
  // Customer List
  getCustomers(): Observable<Customer[]> {
    return this._httpClient.get<Customer[]>(this.url);
  }

  addCustomer(customer: Customer): Observable<Customer> {
    return this._httpClient.post<Customer>(`${this.url}/add`, customer, this.httpOptions);
  }

  updateCustomer(customer: Customer): Observable<Customer> {
    return this._httpClient.put<Customer>(`${this.url}/${customer.customerId}`, JSON.stringify(customer), this.httpOptions);
  }

  getCustomerById(customer: string): Observable<Customer> {
    return this._httpClient.get<Customer>(`${this.url}/${customer}`);
  }
}
