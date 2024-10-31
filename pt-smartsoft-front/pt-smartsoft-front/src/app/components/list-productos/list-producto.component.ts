import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Producto } from '../../models/producto';
import { ProductoService } from '../../services/producto.service';
import { RouterLink, RouterOutlet } from '@angular/router';
import { NgxPaginationModule } from 'ngx-pagination';

@Component({
  selector: 'app-list-producto',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterLink,NgxPaginationModule],
  templateUrl: './list-producto.component.html',
  styleUrl: './list-producto.component.css'
})
export class ListProductoComponent implements OnInit{
  productosLista:Producto[]; //Lista para gaurdar los datos de tipo CLiente
  registrosPorPagina = 10; // Cantidad de registros por página
  paginaActual = 1; // Página actual

  constructor(private productoService : ProductoService){}
  ngOnInit(): void { //Llama a listarClientes
    this.mostrarProductos();
  }
  public mostrarProductos(){ //Metodo Subcribe utiliza el observable
    this.productoService.listarProductos().subscribe(
      lamd =>this.productosLista = lamd
    ); 
  }
}

