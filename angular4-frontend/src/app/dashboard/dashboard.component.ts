import {Component, OnInit} from '@angular/core';
import {Summary} from '../summary';

import { Router } from '@angular/router';
import {DataService} from '../data.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit { 	
  dept: string;
  inst: string;
  lDep: string [];
  lInst: string [];
  
  summary: Summary;
  
  constructor(private dataService: DataService){

  }

  ngOnInit() {
  	this.getAllDep();
  	this.dept = "";
  	this.summary = new Summary();
  }

  private getAllDep(){
  	    this.dataService.getAllDep().then(lDep => this.lDep = lDep);
  	    console.log("Dashboead Component");
  }
  
  private getDepSummary() {
  }

  deptOnChange(){
   		this.dataService.getInstByDep(this.dept).then(lInst => this.lInst = lInst);
   		this.inst='';
  }
  
  onSubmit() {
  		console.log("Instructor"+this.inst);
  		if (this.inst=='')
    		this.dataService.getSummaryByDep(this.dept).then(summary => this.summary = summary);
 		else
    		this.dataService.getSummaryByInst(this.inst).then(summary => this.summary = summary);			
  }  
}