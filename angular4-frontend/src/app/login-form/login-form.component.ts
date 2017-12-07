import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {UserService} from '../user.service';
import {DataService} from '../data.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  constructor(private router:Router, private user:UserService, private dataService: DataService) { }

  ngOnInit() {
    console.log('hit');
  }

  loginUser(e) {
  	e.preventDefault();
  	var username = e.target.elements[0].value;
  	var password = e.target.elements[1].value;
    console.log('usernam : '+username);
  	if(username == 'admin' && password == 'admin') {
     	this.user.setUserLoggedIn();
     	console.log('Yay!');
     	this.dataService.scrapData('bla', 'bla');
  		this.router.navigate(['dashboard']);
  	}
  }

}
