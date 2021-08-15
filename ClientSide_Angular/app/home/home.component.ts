import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { AuthServiceService } from '../auth-service.service';
import { UserData } from '../userData';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  

  email!: string;
  userId!: string;
  pass: string = "";

  user: UserData = new UserData();

  constructor(private authService: AuthServiceService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.user.userEmail = this.email;
    this.user.userId = this.userId;
    this.user.userPassword = this.pass;
    console.log(this.user);
    this.authenticate();
    this.ngOnInit();
  }

  authenticate() {
    this.authService.getUserDetails(this.user)
      .subscribe(data => {
        console.log(data);
        this.login();
      });
  }

  login() {
    this.authService.loggedUser().subscribe(data => this.router.navigateByUrl(`/${data.userRole}`));
  }

  routesTo() {
    this.authService.user = this.user;
  }
}
