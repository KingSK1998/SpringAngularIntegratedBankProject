import { Component, OnInit } from '@angular/core';
import { Account } from './account-data';
import { AccountService } from './account.service';


@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  accountType = "Savings";
  branchId!: number;
  customerId!: string;
  accountBalance = 0;

  accounts: Account[] = [];

  isShowForm = false;
  isShowList = true;

  // Initializing List
  constructor(private accountService: AccountService) {
  }

  ngOnInit(): void {
    this.getAccounts();
  }

  getAccounts() {
    this.accountService.getAccounts().subscribe(data => this.accounts = data);
    console.log("Accounts reterieved", this.accounts);
  }

  addAccount() {
    const account = new Account();
    account.accountType = this.accountType;
    account.balance = this.accountBalance;
    account.branch.branchId = this.branchId;
    account.customers.customerId = this.customerId;

    console.log("Account Adding" + JSON.stringify(account));

    if (
      account.accountType != undefined ||
      account.branch.branchId != undefined ||
      account.customers.customerId != undefined)
      this.accountService.addAccount(account).subscribe(
        data => {
          console.log("response", data);
          this.ngOnInit();
        }
      );
    this.displayList();
  }

  displayForm() {
    this.isShowList = false;
    this.isShowForm = true;
  }

  displayList() {
    this.isShowForm = false;
    this.isShowList = true;
  }
}
