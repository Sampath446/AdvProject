import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { UserService } from 'src/services/users.service';

import { RegUser } from '../models/RegistrationModel';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private snackbar:MatSnackBar, private userService: UserService, private router: Router) { }

 
  @Output('loggedInUser') loggedInuser = new EventEmitter();
  username:string='';
  password:string='';
  ngOnInit(): void {
  }
  login()
  {
    const regUser = new RegUser();
    regUser.username = this.username;
    regUser.password = this.password;
    regUser.name = this.username;
    this.userService.login(regUser).subscribe((resp:any)=>{
      // alert('Login Sucessfully !!' +resp)
      this.userService.userBehavior.next(resp.username);
      localStorage.setItem('username',resp.username);
      this.router.navigate(['/']);
    },error=>{
      alert('Error while login !!' +error);
    })
    
    // this.snackbar.open('login Succefully','close')
  }
 register(){this.router.navigate(['/register']);
  
 }
  
}
