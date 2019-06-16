import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { env } from '../common/environment';

@Injectable({
  providedIn: 'root'
})
export class StockService {

  constructor(private http: HttpClient) { }

  getAllProducts() {
    return this.http.get(`${env.apiUrl}/products`);
  }

  getProductByName(name: string) {
    return this.http.get(`${env.apiUrl}/products/${name}`);
  }

  deleteProduct(id: Number) {
    return this.http.delete(`${env.apiUrl}/products/${id}`);
  }

  addProduct(product: any) {
    return this.http.post(`${env.apiUrl}/products`, product);
  }

  getAllCategories() {
    return this.http.get(`${env.apiUrl}/categories`);
  }
}
