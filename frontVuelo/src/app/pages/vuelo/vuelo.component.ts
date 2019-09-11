import { Component, OnInit } from "@angular/core";
import { NzMessageService } from "ng-zorro-antd";
import { VueloService } from '../../core/services/vuelo/vuelo.service';
import { Subscription, from } from 'rxjs';
import {Vuelo} from 'src/app/core/models/bills/entity/vuelo';
import { newVueloData } from 'src/app/core/models/bills/entity/newVueloData';
import {VueloUseCaseService } from 'src/app/core/use-case/vuelo/vuelo-use-case.service';
import { NzModalService } from 'ng-zorro-antd';


@Component({
  selector: "app-vuelo",
  templateUrl: "./vuelo.component.html",
  styleUrls: ["./vuelo.component.css"]
})

export class VueloComponent implements OnInit {

  responseJson: string;
  getAllVueloApiSub: Subscription;
  deleteVueloApiSub: Subscription;
  isVisible = false;
  visible = false;
  vuelo: any = {};
  newVueloData: newVueloData = this.vuelo;

  constructor(private msg: NzMessageService, private api: VueloService,
     private billsUseCase: VueloUseCaseService, private modalService: NzModalService) {}

  AllVuelo: Vuelo[];
  respuesta: newVueloData;
  respuesta2: string = "juan";

  ngOnInit(): void {
    this.getAllVueloApi();
  }

  getAllVueloApi(): void {
    this.getAllVueloApiSub = this.api.getAllVuelo().subscribe(
      AllVuelo => {this.AllVuelo = AllVuelo;
      });
  }

  deleteBillsApi(vuelo): void {
    this.deleteVueloApiSub = this.api.deleteVueloById(vuelo).subscribe(
      AllVuelo => { this.getAllVueloApi() });
  }

  getAllVueloIdApi(vuelo): void{
    this.api.getVueloById(vuelo).subscribe(
      allVuelo => {
        this.vuelo = allVuelo;
        console.log(this.vuelo);
      });
 }
 updateVueloIdApi(id, VueloData): void{
  this.api.updateVuelo(id, VueloData).subscribe(
    respuesta => {
      this.respuesta = respuesta;
      this.getAllVueloApi();
    });
}

  open(): void {
    this.visible = true;
  }

  close(): void {
    this.visible = false;
  }

  showModal(vuelo): void {
    this.getAllVueloIdApi(vuelo.idVuelo);
    this.isVisible = true;
    this.parseVueloDada();
  }

  parseVueloDada(){
    this.newVueloData.idVuelo = this.vuelo.idVuelo;
    this.newVueloData.pasajero = this.vuelo.pasajero;
    this.newVueloData.Desde = this.vuelo.Desde;
    this.newVueloData.Destino =this. vuelo.Destino;
    this.newVueloData.Fecha = this.vuelo.Fecha;
    this.newVueloData.Hora = this.vuelo.Hora;


  }

  handleOk(): void {
    this.isVisible = false;
    this.parseVueloDada()
    this.updateVueloIdApi(this.vuelo.idVuelo, this.newVueloData);
    console.log(this.newVueloData);
  }

  handleCancel(): void {
    console.log('Button cancel clicked!');
    this.isVisible = false;
  }

  ngOnDestroy() {
    if (this.getAllVueloApiSub) {
      this.getAllVueloApiSub.unsubscribe();
    }
  }

  showDeleteConfirm(vuelo): void {
    this.modalService.confirm({
      nzTitle: 'Se eliminara la factura de '+vuelo.pasajero+'',
      nzContent: '<b style="color: red;">¿Realmente quiere eliminar esta factura?</b>',
      nzOkText: 'Yes',
      nzOkType: 'danger',
      nzOnOk: () => this.deleteBillsApi(vuelo.idVuelo),
      nzCancelText: 'No',
      nzOnCancel: () => console.log('Cancel')
    });
  }

  edit(item: any): void {
    this.msg.success(item.email);
  }


}
