import { Component, OnInit } from '@angular/core';
import { Deposit } from './deposit-data';
import { DepositService } from './deposit.service';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {
  
  customerName!: string;
  depositAmount!: number;
  accountNo!: number;
  dateOfDeposit!: string;

  deposits: Deposit[] = [];

  isShowForm = false;
  isShowList = true;

  // Initializing List
  constructor(private depositService: DepositService) {
  }

  ngOnInit(): void { 
    this.getDeposits();
  }

  getDeposits() {
    this.depositService.getDeposit().subscribe(data => this.deposits = data);
		console.log("Deposit Reterived");
  }

  addDeposit() {
    const deposit = new Deposit();
    deposit.customerName = this.customerName;
    deposit.dateOfDeposit = this.dateOfDeposit;
    deposit.depositAmount = this.depositAmount;
    deposit.account.accountNo = this.accountNo;

    // this.loans.push(loan);
    console.log(deposit);
    if (
			deposit.depositAmount != undefined ||
			deposit.account.accountNo != undefined)
			this.depositService.addDeposit(deposit).subscribe(
			  data => {
				console.log("response", data);
				this.ngOnInit();
			  }
			);
		  this.displayList();
  }

  updateDeposit(deposit: Deposit) {
    // const index = this.loans.indexOf(loan);
    // this.loans.splice(index, 1);
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
