import { Component, OnInit } from '@angular/core';
import { privateEncrypt } from 'crypto';
import { DataSource } from '@angular/cdk/table';

export interface Category {
  name: string;
}

export interface Product {
  position: Number;
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

  constructor() { }

  ngOnInit() {

    this.dataSource = [
      {
        position: 0,
        name: 'XBOX 360',
        price: 800,
        category: {
          name: 'consoles'
        }
      },
      {
        position: 1,
        name: 'PS4',
        price: 300,
        category: {
          name: 'consoles'
        }
      }
    ];

  }

}
