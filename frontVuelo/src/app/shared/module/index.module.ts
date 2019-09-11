import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { CommonModule } from "@angular/common";
import {
  VueloComponent,
 // LoginComponent,
} from "../pages";

@NgModule({
  declarations: [
    VueloComponent,
  //  LoginComponent
  ],
  imports: [CommonModule],
  exports: [
    VueloComponent,
      //  LoginComponent
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ModuleModule {}
