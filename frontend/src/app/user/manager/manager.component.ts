import { Component, OnInit } from '@angular/core';
import { Account } from 'src/app/account/account.model';
import { AccountService } from 'src/app/account/account.service';
import { RequestService } from 'src/app/reimbursement/request.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  newAccount: Account = {
    userID: 0,
    username: '',
    password: '',
    fullName: '',
    email: '',
    role_id: 0,
    role: ''
  }
  
  constructor(private authService: AuthService,
    private accountService: AccountService,
    private requestService: RequestService) { }

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
