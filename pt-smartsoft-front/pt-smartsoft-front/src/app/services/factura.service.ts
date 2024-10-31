import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environments } from '../../environments/environments';
import { Factura } from '../models/factura';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FacturaService {

  private URL_CONSULTA = environments.baseUrl+"/facturas/listar"
  private URL_REGISTRO = environments.baseUrl+"/facturas/registro"
 
  constructor(private clientHttp:HttpClient) { } 

  registrarFactura(factura:Factura,id_cliente:number):Observable<Object>{
    return this.clientHttp.post<any>(`${this.URL_REGISTRO}?id_cliente=${id_cliente}`,factura);
  }
  listarFacturas():Observable<Factura[]>{
    return this.clientHttp.get<Factura[]>(this.URL_CONSULTA);
  }
}
