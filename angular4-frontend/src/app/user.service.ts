import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class UserService {

  private headers = new Headers({'Content-Type': 'application/json'});

  private isUserLoggedIn;
  public username;

  constructor() { 
  	this.isUserLoggedIn = false;
  }

  setUserLoggedIn() {
  	if (this.username != '')
  		this.isUserLoggedIn = true;
  	else 
  		this.isUserLoggedIn = false
  }

  getUserLoggedIn() {
  	console.log("Logged IN user:"+this.isUserLoggedIn);
  	return this.isUserLoggedIn;
  }
  
  //public login(name:string, passwd:string): Promise<string> {
    //const url = 'login/'+name+'/'+passwd;
    //this.username = this.http.get(url)
      //.toPromise()
      //.then(response => response.json() as string)
      //.catch(this.handleError);
      //return this.username;
  //}
  
  private handleError(error: any): Promise<any> {
    console.error('Error', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}