import { Component, OnInit } from '@angular/core';
import { NzMessageService } from "ng-zorro-antd";
import { VueloService } from '../../../core/services/vuelo/vuelo.service';
import { Subscription, from } from 'rxjs';
import {Vuelo} from 'src/app/core/models/bills/entity/vuelo';
import {VueloUseCaseService } from 'src/app/core/use-case/vuelo/vuelo-use-case.service';
import { NzModalService } from 'ng-zorro-antd';

@Component({
  selector: 'app-vuelo-list',
  templateUrl: './vuelo-list.component.html',
  styleUrls: ['./vuelo-list.component.css']
})
export class VueloListComponent implements OnInit {

  getAllVueloApiSub: Subscription;
  AllBill: Vuelo[];

  constructor(private msg: NzMessageService, private api: VueloService, private vueloUseCase: VueloUseCaseService,
    private modalService: NzModalService) { }

    ngOnInit(): void {
      this.getAllVueloApi();
    }

    getAllVueloApi(): void {
      this.getAllVueloApiSub = this.api.getAllVuelo().subscribe(
        AllBill => {this.AllBill = AllBill;
        });
    }



}
