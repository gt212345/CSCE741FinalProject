import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Summary } from './summary';

@Injectable()
export class DataService {

  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) {}

   scrapData(username: string, password:string) {   		
      return this.http.get('scrapeSections'+'/'+username+'/'+password)
       .toPromise()
       .then(response => response.json() as string)
       .catch(this.handleError);
  }

  // Get all customers
  getAllDep(): Promise<string[]> {
  	console.log("Data Service getAllDep")
    return this.http.get('getAllDep')
      .toPromise()
      .then(response => response.json() as string[])
      .catch(this.handleError);
  }

  getInstByDep(dep: string): Promise<string[]> {
    const url = 'getInstByDept/'+dep;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as string[])
      .catch(this.handleError);
  }

  getSummaryByDep(dep: string): Promise<Summary> {
     const url = 'dept/'+dep;
     return this.http.get(url)
       .toPromise()
       .then(response => response.json() as Summary)
       .catch(this.handleError);
  }

  getSummaryByInst(inst: string): Promise<Summary> {
     const url = 'fac/'+inst;
     return this.http.get(url)
       .toPromise()
       .then(response => response.json() as Summary)
       .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Error calling backend API', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}