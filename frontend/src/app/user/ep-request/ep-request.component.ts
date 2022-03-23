import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RequestService } from 'src/app/reimbursement/request.service';
import { Request } from 'src/app/reimbursement/request.model';
import { Account } from 'src/app/account/account.model';
import { AuthService } from '../auth.service';
import { AccountService } from 'src/app/account/account.service';

@Component({
  selector: 'app-ep-request',
  templateUrl: './ep-request.component.html',
  styleUrls: ['./ep-request.component.css']
})
export class EpRequestComponent implements OnInit {
  currentEmployee: any = null;
  allEpRequests: Request[] = [];
  toggleAdd: boolean = false;

  newAccount: Account = {
    userID: 0,
    username: "",
    password: "",
    fullName: "",
    email: "",
    role_id: 0,
    role: ""
  }
  
  newRequest: Request = {
    reqId: 0,
    userId: 0,
    reqType: '',
    reqAmount: 0,
    reqStatus: '',
    submitDate: '',
    approveDate: '',
    manager: ''
  };

  constructor(private requestService: RequestService,
    private router: Router,
    private authService: AuthService,
    private activatedRoute: ActivatedRoute, 
    private accountService: AccountService) { }


  ngOnInit(): void {
    this.currentEmployee = this.authService.retrieveUser();
    console.log(this.currentEmployee);
    this.loadAllRequests();
  }

  toggleAddForm() {
    if(this.toggleAdd) {
      this.toggleAdd = false;
    } else {
      this.toggleAdd = true;
    }
  }

  loadAllRequests() {
    this.currentEmployee= this.authService.retrieveUser();
    this.requestService.viewAllRequest().subscribe((response) => {
      console.log(response);

      for(let i = 0; i < response.length; i++) {
        if(response[i].userId ==this.currentEmployee.userID) {
          this.allEpRequests.push(response[i]);
        }
      }
    });
  }

  addRequest() {
    //let currentUser: any = this.authService.retrieveUser();
    //console.log(currentUser);
    this.newRequest.userId=this.currentEmployee.userID;
    this.requestService.addRequest(this.newRequest).subscribe((response) => {
      console.log(response);
      this.newRequest = {
        reqId: 0,
        userId: 0,
        reqType: '',
        reqAmount: 0,
        reqStatus: '',
        submitDate: '',
        approveDate: '',
        manager: ''
      };

      this.loadAllRequests();
    });
  }
  
}
