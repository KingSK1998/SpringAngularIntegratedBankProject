import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-clerk',
  templateUrl: './clerk.component.html',
  styleUrls: ['./clerk.component.css']
})
export class ClerkComponent implements OnInit {

  private _depost = false;
  private _customer = false;
  private _loan = false;
  private _account = false;

  constructor() { }

  ngOnInit(): void {
  }

  setDepositPage() {
    this._depost = true;
  }

  setCustomerPage() {
    this._customer = true;
  }

  setLoanPage() {
    this._loan = true;
  }

  setAccountPage() {
    this._account = true;
  }

  get DepositPage() {
    return this._depost;
  }

  get CustomerPage() {
    return this._customer;
  }

  get LoanPage() {
    return this._loan;
  }

  get AccountPage() {
    return this._account;
  }
}
