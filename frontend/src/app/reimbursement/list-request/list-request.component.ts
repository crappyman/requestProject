import { Component, OnInit } from '@angular/core';
import { RequestService } from '../request.service';
import { Request } from '../request.model';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/user/auth.service';
import { ConnectableObservable } from 'rxjs';

@Component({
  selector: 'app-list-request',
  templateUrl: './list-request.component.html',
  styleUrls: ['./list-request.component.css']
})
export class ListRequestComponent implements OnInit {

  allRequests: Request[] = [];
  pendingRequests: Request[] = [];
  togglePReq: boolean = false;
  toggleRequests: boolean = false;
  
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
              private authService: AuthService) { }

  ngOnInit(): void {
    this.loadAllRequests();
  }

  togglePending() {
    if(this.togglePReq) {
      this.togglePReq = false;
    } else {
      this.togglePReq = true;
    }
  }

  toggleAllRequests() {
    if(this.toggleRequests) {
      this.toggleRequests = false;
    } else {
      this.toggleRequests = true;
    }
  }

  loadAllRequests() {
    //this has current manager info that logged in
    let currentManager: any = this.authService.retrieveUser();
    console.log(currentManager);
    this.allRequests = []
    //get all requests from the backend and stored in response
    this.requestService.viewAllRequest().subscribe((response) => {
      console.log("Hello", response); // a list of all requests
      for(let i = 0; i < response.length; i++) {
        if(response[i].manager == currentManager.userID) {
          if(response[i].reqStatus == "1")
            this.pendingRequests.push(response[i]);
          this.allRequests.push(response[i]);
        }  
      }
    });
  }
  
  acceptRequest(reqId : number) {
    this.requestService.acceptRequest(reqId).subscribe(  response => {
      
      this.loadAllRequests()
    });
  }
  denieRequest(reqId:number){
    this.requestService.denieRequest(reqId).subscribe(Response => { this.loadAllRequests()});
  }
  // addRequest() {
  //   this.requestService.addRequest(this.newRequest).subscribe((response) => {
  //     console.log(response);
  //     this.newRequest = {
  //       reqId: 0,
  //       userId: 0,
  //       reqType: '',
  //       reqAmount: 0,
  //       reqStatus: '',
  //       submitDate: '',
  //       approvedDate: '',
  //       manager: ''
  //     };

  //     this.loadAllRequests();
  //   });
  // }
}
