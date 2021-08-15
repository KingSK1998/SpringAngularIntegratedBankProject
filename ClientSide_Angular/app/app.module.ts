import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BankComponent } from './bank/bank.component';
import { ManagerComponent } from './manager/manager.component';
import { ClerkComponent } from './clerk/clerk.component';
import { BankEmployeeComponent } from './bank-employee/bank-employee.component';
import { BranchComponent } from './branch/branch.component';
import { AccountComponent } from './account/account.component';
import { CustomerComponent } from './customer/customer.component';
import { DepositComponent } from './deposit/deposit.component';
import { LoanComponent } from './loan/loan.component';
import { ProjectBaseComponent } from './project-base/project-base.component';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './home/home.component';
import { BankFormComponent } from './bank/bank-form/bank-form.component';

@NgModule({
  declarations: [
    AppComponent,
    BankComponent,
    ManagerComponent,
    ClerkComponent,
    BankEmployeeComponent,
    BranchComponent,
    AccountComponent,
    CustomerComponent,
    DepositComponent,
    LoanComponent,
    ProjectBaseComponent,
    AdminComponent,
    HomeComponent,
    BankFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
