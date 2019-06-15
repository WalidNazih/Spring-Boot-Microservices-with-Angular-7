import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { env } from '../common/environment';

@Injectable({
  providedIn: 'root'
})
export class StockService {

  constructor(private http: HttpClient) { }

  getAllProducts (){
    return this.http.get(`${env.apiUrl}/products`);
  }
}
