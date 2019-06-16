import { Component, OnInit } from '@angular/core';
import { StockService } from '../services/stock.service';
import { AddProductDialogComponent } from './add-product-dialog/add-product-dialog.component';
import { MatDialog } from '@angular/material';

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
  searchToken: string;
  constructor(private stockService: StockService, private dialog: MatDialog) { }

  ngOnInit() {
    this.getAllProducts();
  }

  getAllProducts() {
    this.stockService.getAllProducts().subscribe((products: Product[]) => {
      this.dataSource = products;
    });
  }

  searchForProduct() {
    this.stockService.getProductByName(this.searchToken).subscribe((products: Product[]) => {
      this.dataSource = products;
    });
  }

  deleteProduct(id: Number) {
    this.stockService.deleteProduct(id).subscribe(() => {
      this.getAllProducts();
    });
  }

  openAddProductDialog() {
    const dialogRef = this.dialog.open(AddProductDialogComponent, {
      width: '40%'
    });

    dialogRef.afterClosed().subscribe(() => {
      this.getAllProducts();
    });
  }

}
