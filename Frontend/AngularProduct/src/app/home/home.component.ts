import { Component, OnInit } from '@angular/core';
import { privateEncrypt } from 'crypto';
import { DataSource } from '@angular/cdk/table';
import { StockService } from '../services/stock.service';

export interface Category {
  name: string;
}

export interface Product {
  id: Number;
  name: string;
  price: Number;
  category: Category;
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  displayedColumns: string[] = ['position', 'name', 'price', 'category', 'delete'];
  dataSource: Product[];
  constructor(private stockService: StockService) { }

  ngOnInit() {
    this.stockService.getAllProducts().subscribe((products: Product[]) => {
      this.dataSource = products;
    });
  }

}
