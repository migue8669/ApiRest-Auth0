import { Component, OnInit } from '@angular/core';
import { NzModalRef } from 'ng-zorro-antd';
@Component({
  selector: 'app-edit-vuelo',
  templateUrl: './edit-vuelo.component.html',
  styleUrls: ['./edit-vuelo.component.css']
})
export class EditVueloComponent implements OnInit {

  constructor( private modal: NzModalRef ) { }

  ngOnInit() {
  }
  destroyModal(): void {
    this.modal.destroy();
  }

}
