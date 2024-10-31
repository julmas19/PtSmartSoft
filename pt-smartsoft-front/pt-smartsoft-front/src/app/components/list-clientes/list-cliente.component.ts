import { Component } from '@angular/core';
import { Cliente } from '../../models/cliente';
import { ClienteService } from '../../services/cliente.service';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterOutlet } from '@angular/router';
import { NgxPaginationModule } from 'ngx-pagination';


@Component({
  selector: 'app-list-cliente',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterLink,NgxPaginationModule],
  templateUrl: './list-cliente.component.html',
  styleUrl: './list-cliente.component.css'
})
export class ListClienteComponent {
  clientesLista:Cliente[]; //Lista para gaurdar los datos de tipo CLiente
  registrosPorPagina = 10; // Cantidad de registros por página
  paginaActual = 1; // Página actual
  
  constructor(private clienteService : ClienteService){}
  ngOnInit(){ //Llama a listarClientes
    this.mostrarClientes();
  }
  public mostrarClientes(){ //Metodo Subcribe utiliza el observable
    this.clienteService.listarClientes().subscribe(
      lamd =>this.clientesLista = lamd
    ) 
  }

  
}
