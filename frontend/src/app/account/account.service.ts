import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from './account.model';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http: HttpClient) { }

  fetchAllAccount(): Observable<Account[]> {
    return this.http.get<Account[]>("http://localhost:4444/api/user/users");
  }

  // deleteAccount(userId: number): Observable<Account[]> {
  //   return this.http.delete<Account[]>("");
  // }
  // addAccount(accountModel: Account): Observable<Account> {
  //   return this.http.post<Account>();
  // }

  updateAccount(accountModel: Account): Observable<Account> {
    return this.http.put<Account>("http://localhost:4444/api/user/updateUser", accountModel);
  }

  fetchAAccount(userId: any): Observable<Account> {
    return this.http.get<Account>("http://localhost:4444/api/user/users/"+userId);
  }
}
