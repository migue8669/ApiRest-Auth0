import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, } from "@angular/common/http";
import { Observable } from "rxjs";
import { Vuelo } from "../../models/bills/entity/vuelo";
import { newVueloData } from "../../models/bills/entity/newVueloData";
import { catchError, map, tap } from "rxjs/operators";
import { environment } from "src/environments/environment";
import { VueloAbstract } from "../../models/bills/gateway/Vuelo-gateway.abstract";



const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" })
};

@Injectable({
  providedIn: "root"
})
export class VueloService extends VueloAbstract {


  private clientsUrl = `${environment.host}:${environment.port}/vuelo`;

  constructor(private http: HttpClient) {
    super();
  }




  getAllVuelo(): Observable<Vuelo[]> {
    return this.http.get<Vuelo[]>(`http://localhost:8080/vuelo/allVuelo`);
  }

  getVueloByName(nameClient:string): Observable<Vuelo[]> {
    return this.http.get<Vuelo[]>(this.clientsUrl);
  }
  updateVuelo(id: string, data: newVueloData): Observable<newVueloData> {
    return this.http.put<newVueloData>(`http://localhost:8080/vuelo/updateByIdVuelo/${id}`, JSON.stringify(data));

  }

  deleteVueloById(id: string): Observable<Vuelo> {
    return this.http.delete<Vuelo>(`http://localhost:8080/vuelo/deleteVueloById/${id}`);
  }

  getVueloById(id: string): Observable<Vuelo> {
    return this.http.get<Vuelo>(`http://localhost:8080/vuelo/getByIdVuelo/${id}`);
  }

  saveNewVuelo(newBillData): Observable<newVueloData> {
    return this.http.post<newVueloData>(`http://localhost:8080/vuelo/saveNewVuelo`, JSON.stringify(newVueloData));
  }
}
