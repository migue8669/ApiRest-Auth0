import { Injectable } from '@angular/core';
//import { Bills, newVueloData } from './node_modules/src/app/core/models/index.model';
import { Vuelo, newVueloData } from '../../models/index.model';

import { Observable } from 'rxjs';
import { VueloService } from '../../services/vuelo/vuelo.service';

@Injectable({
  providedIn: 'root'
})
export class VueloUseCaseService {

  constructor(private vueloService: VueloService) {}

  postVueloService(vuelo: newVueloData): Observable<newVueloData> {
    return this.vueloService.saveNewVuelo(newVueloData);
  }
  getAllVueloService(): Observable<Vuelo[]> {
    return this.vueloService.getAllVuelo();
  }
}
