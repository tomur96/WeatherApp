import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

interface Weather {
  main: {
    temp: string;
    feels_like: string;
    pressure: string;
    temp_max: string;
    temp_min: string;
    humidity: string
  }

}

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {
  city: string = "";
  weather: Weather | undefined;

  constructor(
    private http: HttpClient
  ) { }

  ngOnInit(): void {
  }

  submit() {
    this.http.get("/api/weather/" + this.city).subscribe((response:any)=>{
      console.log(response);
      this.weather = response;
    })
  }
}
