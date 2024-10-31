import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environments } from '../../environments/environments';
import { Observable } from 'rxjs';
import { Detalle } from '../models/detalle';

@Injectable({
  providedIn: 'root'
})
export class DetalleService {

  private URL_CONSULTA = environments.baseUrl+"/detalles/listar"
  private URL_REGISTRO = environments.baseUrl+"/detalles/registro"
  
  constructor(private clientHttp:HttpClient) { } 

  registrarDetalle(detalle:Detalle,num_factura:number):Observable<Object>{
    return this.clientHttp.post<any>(`${this.URL_REGISTRO}?num_factura=${num_factura}`,detalle);
  }
  listarDetalles():Observable<Detalle[]>{
    return this.clientHttp.get<Detalle[]>(this.URL_CONSULTA);
  }
}
