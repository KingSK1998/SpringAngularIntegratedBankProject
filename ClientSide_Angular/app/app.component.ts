import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from './auth-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = "APP COMPONENT";

  constructor(private router: Router) {};

  adminActive(): boolean {
    if(
      this.router.isActive("/admin", true) ||
      this.router.isActive("/bank", true) ||
      this.router.isActive("/branch", true))
      return true;
    return false;
  }

  activeManager(): boolean {
    if(
      this.router.isActive("/manager", true) ||
      this.router.isActive("/loan", true) ||
      this.router.isActive("/bank-employee", true))
      return true;
    return false;
  }

  activeClerk(): boolean {
    if(
      this.router.isActive("/clerk", true) ||
      this.router.isActive("/account", true) ||
      this.router.isActive("/customer", true) ||
      this.router.isActive("/deposit", true))
      return true;
    return false;
  }

  activeHome(): boolean {
    if(this.router.isActive("/home", true))
      return true;
    return false;
  }

}
