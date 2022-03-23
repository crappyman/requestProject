import { Component, OnInit } from '@angular/core';
import { AuthService } from '../user/auth.service';
import { User } from '../user/login/user.model';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  isLoggedIn(): boolean{
    return this.authService.loggedIn;
  }

  getRole(): number {
    let data: User = this.authService.retrieveUser();
    return data.role_id;
  }
  
}
