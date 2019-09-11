import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import {
  LoginService,
  VueloService
} from "./index.services";

import { AuthenticationAbstract } from "../../core/models/login/gateway/autentication-gateway.abstract";
import { VueloAbstract } from "../../core/models/bills/gateway/Vuelo-gateway.abstract";


@NgModule({
  declarations: [],
  imports: [CommonModule],
  providers: [
    { provide: AuthenticationAbstract, useClass: LoginService },
    { provide: VueloAbstract, useClass: VueloService },
  ]
})
export class ServiceModule {}
