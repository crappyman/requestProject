import { Injectable } from '@angular/core';
import { ConnectableObservable } from 'rxjs';
import { User } from './login/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  //purpose of this service is to store and retrieve use info from browser storage
  //and mark if a person has logged in or logged
  constructor() { }

  loggedIn: boolean = false;

  storeUser(user: User) {
    //javascript object     key used to get user values
    sessionStorage.setItem("userInfo", JSON.stringify(user));
  }

  retrieveUser(): User {
    let data: any = sessionStorage.getItem("userInfo");
    return JSON.parse(data);
  }

  destroyUser(): void {
    sessionStorage.removeItem("userInfo");
  }
}
