import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MatSidenavModule, MatToolbarModule, MatIconModule, MatTableModule, MatInputModule, MatButtonModule } from '@angular/material';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';

import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { StockService } from './services/stock.service';
import { HttpClientModule } from '@angular/common/http';

const routes: Routes = [
  { path: '', component: HomeComponent },
];


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeComponent
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
    RouterModule.forRoot(routes)
  ],
  providers: [StockService],
  bootstrap: [AppComponent]
})
export class AppModule { }
