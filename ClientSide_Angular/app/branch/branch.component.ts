import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bank } from '../bank/bank-data';
import { BankService } from '../bank/bank-service.service';
import { Branch } from './branch-data';
import { BranchService } from './branch.service';


@Component({
  selector: 'app-branch',
  templateUrl: './branch.component.html',
  styleUrls: ['./branch.component.css']
})
export class BranchComponent implements OnInit {

  branchs: Branch[] = [];
  banks: Bank[] = [];

  bId!: number;
  bName!: string;
  bAdd!: string;
  bCode!: number;

  bankCode!: number;

  isShowForm = false;
  isShowList = true;

  bankOnlyOnce = true;
  branchOnlyOnce = true;

  constructor(
    private branchService: BranchService,
    private bankService: BankService
  ) {
  }

  ngOnInit(): void {
    this.getBranchs();
  }

  addBranch() {
    const branch = new Branch();
    branch.branchName = this.bName;
    branch.branchAddress = this.bAdd;
    branch.bank.bankCode = this.bankCode;

    console.log("Branch Adding" + JSON.stringify(branch));

    if (branch.branchName != undefined || branch.branchAddress != undefined)
      this.branchService.addBranch(branch).subscribe(
        data => {
          console.log("response", data);
          this.ngOnInit();
        }
      );
    this.displayList();
  }

  getBranchs() {
    this.branchService.getBranchs().subscribe(data => this.branchs = data);
    console.log("Branch reterieved", this.branchs);
  }

  getBanks() {
    this.bankService.getBanks().subscribe(data => this.banks = data);
  }

  updateBranch(branch: Branch) {
    const index = this.branchs.indexOf(branch);
    this.branchs.splice(index, 1);
    console.log("Branch: " + JSON.stringify(branch));
  }

  // ---------------------------------------------------------------------------

  displayForm() {
    this.isShowList = false;
    this.isShowForm = true;
    this.getBanks();
  }

  displayList() {
    this.isShowForm = false;
    this.isShowList = true;
  }
}
