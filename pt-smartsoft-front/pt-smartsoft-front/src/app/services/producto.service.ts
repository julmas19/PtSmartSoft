import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from '../models/producto';
import { HttpClient } from '@angular/common/http';
import { environments } from '../../environments/environments';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private URL_CONSULTA = environments.baseUrl+"/productos/listar"
  private URL_REGISTRO = environments.baseUrl+"/productos/registro"
 
  constructor(private clientHttp:HttpClient) { } 

  registrarProducto(producto:Producto):Observable<Object>{
    return this.clientHttp.post(this.URL_REGISTRO,producto);
  }
  listarProductos():Observable<Producto[]>{
    return this.clientHttp.get<Producto[]>(this.URL_CONSULTA);
  }
}
