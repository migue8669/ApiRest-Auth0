import { Observable } from "rxjs";
import { Vuelo, newVueloData } from "../../index.model";

export abstract class VueloAbstract {
  abstract getAllVuelo(): Observable<Vuelo[]>;
  abstract updateVuelo(id: string, data: newVueloData): Observable<newVueloData>;
  abstract deleteVueloById(id: string): Observable<Vuelo>;
  abstract getVueloById(id: string): Observable<Vuelo>;
  abstract getVueloByName(nameClient: string): Observable<Vuelo[]>;
  abstract saveNewVuelo(body: string[]): Observable<newVueloData>;
}
