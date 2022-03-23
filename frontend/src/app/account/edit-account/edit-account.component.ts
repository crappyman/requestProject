import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from '../account.model';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-edit-account',
  templateUrl: './edit-account.component.html',
  styleUrls: ['./edit-account.component.css']
})
export class EditAccountComponent implements OnInit {

  newAccount: Account = {
    userID: 0,
    username: "",
    password: "",
    fullName: "",
    email: "",
    role_id: 0,
    role: ""
  }
  
  constructor(private activatededRoute: ActivatedRoute, 
              private accountService: AccountService,
              private router: Router) { }

  ngOnInit(): void {
    let accountId: any = this.activatededRoute.snapshot.paramMap.get("id")
    //this.newAccount = this.accountService.fetchAAccount(accountId);
  }

  updateAccount() {
    this.accountService.updateAccount(this.newAccount);
    this.router.navigate(['account-crud']);
  }
}
