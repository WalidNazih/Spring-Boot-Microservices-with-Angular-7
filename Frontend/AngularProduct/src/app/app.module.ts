import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MatSidenavModule, 
         MatToolbarModule, 
         MatIconModule, 
         MatTableModule, 
         MatInputModule, 
         MatButtonModule, 
         MatDialogModule, 
         MatFormFieldModule,
         MatSelectModule,
         MatOptionModule } from '@angular/material';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';

import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { StockService } from './services/stock.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddProductDialogComponent } from './home/add-product-dialog/add-product-dialog.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
];


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeComponent,
    AddProductDialogComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    FlexLayoutModule,
    MatTableModule,
    MatInputModule,
    MatButtonModule,
    HttpClientModule,
    FormsModule,
    MatDialogModule,
    MatSelectModule,
    MatOptionModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes)
  ],
  entryComponents: [AddProductDialogComponent],
  providers: [StockService],
  bootstrap: [AppComponent]
})
export class AppModule { }
