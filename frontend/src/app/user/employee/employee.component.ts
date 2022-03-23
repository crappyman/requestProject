import { Component, OnInit } from '@angular/core';
import { Account } from 'src/app/account/account.model';
import { AccountService } from 'src/app/account/account.service';
import { AuthService } from '../auth.service';
import { User } from '../login/user.model';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  newAccount: Account = {
    userID: 0,
    username: '',
    password: '',
    fullName: '',
    email: '',
    role_id: 0,
    role: ''
  }
  
  constructor(private accountService: AccountService,
              private authService: AuthService) { }

  ngOnInit(): void {
    this.loadCurrentUser();
  }

  loadCurrentUser() {
    let currentUser: any = this.authService.retrieveUser();
    this.accountService.fetchAAccount(currentUser.userID).subscribe((response) => {
      this.newAccount = response;
    });
  }
}
