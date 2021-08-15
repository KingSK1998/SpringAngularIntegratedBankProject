import { Component, OnInit } from '@angular/core';
import { Loan } from './loan-data';
import { LoanService } from './loan.service';

@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css']
})
export class LoanComponent implements OnInit {

  loanType = "Home";
  loanAmount = 1000;
  accountNo!: number;

  loans: Loan[] = [];

  isShowForm = false;
  isShowList = true;

  // Initializing List
  constructor(private loanService: LoanService) {
  }

  ngOnInit(): void { 
    this.getLoans();
  }

  getLoans() {
    this.loanService.getLoan().subscribe(data => this.loans = data);
		console.log("Loan Reterived");
  }

  addLoan() {
    const loan = new Loan();
    loan.loanType = this.loanType;
    loan.loanAmount = this.loanAmount;
    loan.account.accountNo = this.accountNo;

    // this.loans.push(loan);
    console.log(loan);
    if (
			loan.loanType != undefined ||
			loan.account.accountNo != undefined)
			this.loanService.addLoan(loan).subscribe(
			  data => {
				console.log("response", data);
				this.ngOnInit();
			  }
			);
		  this.displayList();
  }

  updateLoan(loan: any) {
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
