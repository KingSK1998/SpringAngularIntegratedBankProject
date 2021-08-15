import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountComponent } from './account/account.component';
import { AdminComponent } from './admin/admin.component';
import { BankEmployeeComponent } from './bank-employee/bank-employee.component';
import { BankFormComponent } from './bank/bank-form/bank-form.component';
import { BankComponent } from './bank/bank.component';
import { BranchComponent } from './branch/branch.component';
import { ClerkComponent } from './clerk/clerk.component';
import { CustomerComponent } from './customer/customer.component';
import { DepositComponent } from './deposit/deposit.component';
import { HomeComponent } from './home/home.component';
import { LoanComponent } from './loan/loan.component';
import { ManagerComponent } from './manager/manager.component';

const routes: Routes = [
  // HOME
  { path: 'home', component: HomeComponent },
  // MAIN LOGINS
  { path: 'admin', component: AdminComponent },
  { path: 'manager', component: ManagerComponent },
  { path: 'clerk', component: ClerkComponent },
  // REST
  { path: 'bank-employee', component: BankEmployeeComponent },
  
  { path: 'bank', component: BankComponent },
  { path: 'bank/add', component: BankFormComponent },

  { path: 'branch', component: BranchComponent },
  { path: 'account', component: AccountComponent },
  { path: 'customer', component: CustomerComponent },
  { path: 'loan', component: LoanComponent },
  { path: 'deposit', component: DepositComponent},
  // IF Component not found
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
