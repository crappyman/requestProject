import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private authService: AuthService, 
              private router: Router) { }

  ngOnInit(): void {
    //destroy user info
    this.authService.destroyUser();

    //mark they have loggedout
    this.authService.loggedIn=false;

    //nav to login component
    this.router.navigate(['login']);
  }

}
