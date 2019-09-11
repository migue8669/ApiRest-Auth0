import { NgModule } from "@angular/core";
//import { AddVueloComponent } from "./add-vuelo/add-vuelo.component";
import { AddVueloComponent } from "./add-vuelo/add-vuelo.component";
//import { EditVueloComponent } from "./edit-vuelo/edit-vuelo.component";
import { VueloComponent } from "./vuelo.component";

@NgModule({
    declarations:[
        VueloComponent,
        AddVueloComponent
    ],
    imports:[],
    exports:[
      AddVueloComponent,
    ]
})
export class VueloModule {}
