import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Branch } from './branch-data';

@Injectable({
  providedIn: 'root'
})
export class BranchService {
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  private url = "http://localhost:8080/BankProject/admin/branch";
  
  constructor(private _httpClient: HttpClient) { }
  
  // Branch List
  getBranchs(): Observable<Branch[]> {
    return this._httpClient.get<Branch[]>(this.url);
  }

  addBranch(branch: Branch): Observable<Branch> {
    return this._httpClient.post<Branch>(`${this.url}/add`, branch, this.httpOptions);
  }

  updateBranch(branch: Branch): Observable<Branch> {
    return this._httpClient.put<Branch>(`${this.url}/${branch.branchId}`, JSON.stringify(branch), this.httpOptions);
  }

  getBranchById(branchId: string): Observable<Branch> {
    return this._httpClient.get<Branch>(`${this.url}/${branchId}`);
  }
}
