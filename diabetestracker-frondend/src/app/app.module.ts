import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { GlycemieService } from './glycemie.service';
import { HttpClientModule } from '@angular/common/http';import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule, FormsModule
  ],
  providers: [GlycemieService],
  bootstrap: [AppComponent]
})
export class AppModule { }