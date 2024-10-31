import { Injectable } from '@angular/core';
import { environments } from '../../environments/environments';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cliente } from '../models/cliente';
@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private URL_CONSULTA = environments.baseUrl+"/clientes/listar"
  private URL_REGISTRO = environments.baseUrl+"/clientes/registro"
 
  
  constructor(private clientHttp:HttpClient) { } 

  listarClientes():Observable<Cliente[]>{
    return this.clientHttp.get<Cliente[]>(this.URL_CONSULTA);
  }
  
  registrarCliente(cliente:Cliente):Observable<Object>{
    return this.clientHttp.post(this.URL_REGISTRO,cliente);
  }
}
