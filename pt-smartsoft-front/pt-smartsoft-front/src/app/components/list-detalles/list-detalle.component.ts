import { RouterLink, RouterOutlet } from '@angular/router';
import { NgxPaginationModule } from 'ngx-pagination';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Detalle } from '../../models/detalle';
import { DetalleService } from '../../services/detalle.service';
@Component({
  selector: 'app-list-detalle',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterLink,NgxPaginationModule],
  templateUrl: './list-detalle.component.html',
  styleUrl: './list-detalle.component.css'
})
export class ListDetalleComponent {
  detallesLista:Detalle[]; //Lista para gaurdar los datos de tipo CLiente
  registrosPorPagina = 10; // Cantidad de registros por página
  paginaActual = 1; // Página actual
  
  constructor(private detalleService : DetalleService){}
  ngOnInit(): void { //Llama a listarClientes
    this.mostrarDetalles();
  }
  public mostrarDetalles(){ //Metodo Subcribe utiliza el observable
    this.detalleService.listarDetalles().subscribe(
      lamd =>this.detallesLista = lamd
    ); 
  }
}
