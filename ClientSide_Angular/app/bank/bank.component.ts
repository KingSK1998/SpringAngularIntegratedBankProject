import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bank } from './bank-data';
import { BankService } from './bank-service.service';


@Component({
  selector: 'app-bank',
  templateUrl: './bank.component.html',
  styleUrls: ['./bank.component.css']
})
export class BankComponent implements OnInit {

  banks: Bank[] = [];
  editBank: Bank = new Bank();
  statusMessage!: string;

  isShowForm = false;
  isShowList = true;

  dummyExecuteOnlyOnce = true;

  constructor(private bankService: BankService, private router: Router) {
  }

  ngOnInit(): void {
    this.getBanks();
  }

  getBanks() {
    this.bankService.getBanks()
      .subscribe(banks => (this.banks = banks),
      error => {
        console.log(error);
        this.statusMessage = 'Problem with service. Please try again later!';
      }
      );
      console.log("Bank reterieved");
    }
    
    
    
  updateBank(bank: Bank) {
    if (bank) {
      this.bankService.updateBank(bank)
        .subscribe(
          data => {
            const id = data ? this.banks.findIndex(b => b.bankCode === data.bankCode) : -1;
            if (id > -1) {
              console.log(bank);
              
            }
          }
        );
    }
  }

  getBank(bankCode: string) {
    // this.editBank = undefined;
    if (bankCode) {
      this.bankService.getBankByCode(bankCode)
        .subscribe(data => {
          this.editBank = data;
          this.getBanks();
        })
    }
  }

  displayForm() {
    this.isShowList = false;
    this.isShowForm = !this.isShowForm;
  }

  displayList() {
    this.isShowForm = false;
    this.isShowList = !this.isShowList;
  }
}
