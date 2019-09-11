import { Component, OnInit } from '@angular/core';
import { NzModalService } from 'ng-zorro-antd';
import {FormBuilder, FormGroup } from '@angular/forms'
import { VueloComponent } from '../vuelo.component';
import { VueloService } from '../../../core/services/vuelo/vuelo.service';
import {Vuelo} from 'src/app/core/models/bills/entity/vuelo';
import { Subscription } from 'rxjs';
import { newVueloData } from 'src/app/core/models/bills/entity/newVueloData';

@Component({
  selector: 'app-add-vuelo',
  templateUrl: './add-vuelo.component.html',
  styleUrls: ['./add-vuelo.component.css']
})
export class AddVueloComponent implements OnInit {
  visible = false;
  formulario: FormGroup;
  saveNewVueloApiSub: Subscription;
  AllVuelo: newVueloData;

  constructor(private builder: FormBuilder, private vuelo: VueloComponent, private api: VueloService) {
    this.formulario = this.builder.group({
      pasajero: [""],
      desde: [""],
      destino: [""],
      fecha: [""],
      hora: [""],

    })
  }

  enviar(vuelo:newVueloData) {
    this.saveNewVueloApiSub = this.api.saveNewVuelo(vuelo).subscribe(
      AllVuelo => {this.AllVuelo = AllVuelo;
                  this.vuelo.getAllVueloApi() });
  }

  close(): void {
    this.visible = false;
    this.vuelo.close()
  }

  ngOnInit() {
  }

}
