import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FacturaService } from '../../services/factura.service';
import { Factura } from '../../models/factura';
import { RouterLink, RouterOutlet } from '@angular/router';
import { NgxPaginationModule } from 'ngx-pagination';
@Component({
  selector: 'app-list-factura',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterLink,NgxPaginationModule],
  templateUrl: './list-factura.component.html',
  styleUrl: './list-factura.component.css'
})
export class ListFacturaComponent {
  facturasLista:Factura[]; //Lista para gaurdar los datos de tipo CLiente
  registrosPorPagina = 10; // Cantidad de registros por página
  paginaActual = 1; // Página actual
  
  constructor(private facturaService : FacturaService){}
  ngOnInit(): void { //Llama a listarClientes
    this.mostrarFacturas();
  }
  public mostrarFacturas(){ //Metodo Subcribe utiliza el observable
    this.facturaService.listarFacturas().subscribe(
      lamd =>this.facturasLista = lamd
    ); 
  }
}
