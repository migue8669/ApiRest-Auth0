import { BrowserModule } from "@angular/platform-browser";
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { NgZorroAntdModule, NZ_I18N, en_US, zh_CN, es_ES } from "ng-zorro-antd";
import json from 'highlight.js/lib/languages/json';


import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { registerLocaleData } from "@angular/common";
import { BasicAuthInterceptor } from "./core/basic-auth.interceptor";
import zh from "@angular/common/locales/zh";
import { HourTypePipe } from "./shared/pipes/hour-type.pipe";
import { ServiceModule } from "./shared/service/service.module";
import { ServiceUseCaseModule } from "./shared/service-use-case/service-use-case.module";
import{VueloListComponent} from ".././app/pages/vuelo/vuelo-list/vuelo-list.component"
import { AddVueloComponent } from "../app/pages/vuelo/add-vuelo/add-vuelo.component";
import { ToastrModule } from "ngx-toastr";

export function hljsLanguages() {
  return [{ name: 'json', func: json }];
}

import {
  VueloComponent,
} from "./shared/pages";



registerLocaleData(zh);

@NgModule({
  declarations: [
    AppComponent,
    HourTypePipe,
    VueloComponent,
    // BillsListComponent,
    AddVueloComponent
    //BillsListComponent
    //LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgZorroAntdModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    ServiceModule,
    ServiceUseCaseModule,
    ToastrModule.forRoot()
  ],
  providers: [
    { provide: NZ_I18N, useValue: en_US },
    { provide: HTTP_INTERCEPTORS, useClass: BasicAuthInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
