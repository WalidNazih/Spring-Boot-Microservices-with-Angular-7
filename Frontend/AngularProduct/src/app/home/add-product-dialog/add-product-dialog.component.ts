import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { StockService } from 'src/app/services/stock.service';

export interface Category {
  id: number,
  name: string
}

@Component({
  selector: 'app-add-product-dialog',
  templateUrl: './add-product-dialog.component.html',
  styleUrls: ['./add-product-dialog.component.scss']
})
export class AddProductDialogComponent implements OnInit {

  addProductForm: FormGroup;
  categories: Category[];

  constructor(private dialog: MatDialogRef<AddProductDialogComponent>, 
              private stockService: StockService) { }

  ngOnInit() {

    this.addProductForm = new FormGroup({
      'name': new FormControl('', [Validators.required, Validators.minLength(2)]),
      'price': new FormControl('', [Validators.required]),
      'category': new FormControl('', [Validators.required])
    });

    this.stockService.getAllCategories().subscribe((categories: Category[]) => {
      this.categories = categories;
    });

  }

  get productForm() {
    return this.addProductForm.controls;
  }

  onNoClick() {
    this.dialog.close();
  }

  addProduct() {
    const product = {
      name: this.productForm.name.value,
      price: this.productForm.price.value,
      category: {
        id: this.productForm.category.value
      }
    };

    this.stockService.addProduct(product).subscribe(() => {
      this.dialog.close();
    });
  }

}
