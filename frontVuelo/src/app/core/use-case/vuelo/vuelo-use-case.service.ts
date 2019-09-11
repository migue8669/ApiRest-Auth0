import { Injectable } from '@angular/core';
import { Vuelo, newVueloData } from 'src/app/core/models/index.model';
import { Observable } from 'rxjs';
import { VueloService } from '../../services/vuelo/vuelo.service';

@Injectable({
  providedIn: 'root'
})
export class VueloUseCaseService {

  constructor(private vueloService: VueloService) {}

  postVueloervice(vuelo: newVueloData): Observable<newVueloData> {
    return this.vueloService.saveNewVuelo(newVueloData);
  }
  getAllVueloService(): Observable<Vuelo[]> {
    return this.vueloService.getAllVuelo();
  }
}
