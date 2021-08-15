import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bank } from '../bank-data';
import { BankService } from '../bank-service.service';

@Component({
  selector: 'app-bank-form',
  templateUrl: './bank-form.component.html',
  styleUrls: ['./bank-form.component.css']
})
export class BankFormComponent implements OnInit {

  bankName!: string;
  bankAddress!: string;

  constructor(private _bankService: BankService, private _router: Router) { }

  ngOnInit(): void {
  }

  addBank() {
    const bank = new Bank();
    bank.bankName = this.bankName;
    bank.bankAddress = this.bankAddress;
    console.log(bank);
    if (bank.bankName != undefined || bank.bankAddress != undefined)
      this._bankService.addBank(bank).subscribe(
        data => {
          console.log("response", data);
          this._router.navigateByUrl("/bank");
        }
      );
  }
}
