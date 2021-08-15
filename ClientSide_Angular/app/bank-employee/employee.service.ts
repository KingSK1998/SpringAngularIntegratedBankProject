import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee-data';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  private url = "http://localhost:8080/BankProject/manager/employee";
  
  constructor(private _httpClient: HttpClient) { }
  
  // Customer List
  getEmployees(): Observable<Employee[]> {
    return this._httpClient.get<Employee[]>(this.url);
  }

  addEmployee(employee: Employee): Observable<Employee> {
    return this._httpClient.post<Employee>(`${this.url}/add`, employee, this.httpOptions);
  }

  updateEmployee(employee: Employee): Observable<Employee> {
    return this._httpClient.put<Employee>(`${this.url}/${employee.employeeId}`, JSON.stringify(employee), this.httpOptions);
  }

  getEmployeeById(employeeId: string): Observable<Employee> {
    return this._httpClient.get<Employee>(`${this.url}/${employeeId}`);
  }
}
