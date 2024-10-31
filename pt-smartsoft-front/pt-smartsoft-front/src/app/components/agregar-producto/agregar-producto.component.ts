import { Component } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms'
import { Producto } from '../../models/producto';
import { ProductoService } from '../../services/producto.service';
@Component({
  selector: 'app-agregar-producto',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterOutlet, RouterLink],
  templateUrl: './agregar-producto.component.html',
  styleUrl: './agregar-producto.component.css'
})
export class AgregarProductoComponent {
  producto:Producto = new Producto();
  mensajeError: string = ''; // Inicializamos con un valor vacío
  detalleError: any = ''; // Inicializamos con un valor vacío
  mensajeCorrecto: string = ''; // Inicializamos con un valor vacío
  respuesta:any

  registroCreado:boolean; //Valida que el registro se haya creado para inhabilitar los campos

  constructor(private productoService:ProductoService,private router:Router){}

  onSubmit(){
    this.mensajeCorrecto='';
    this.mensajeError='';
    this.guardarProducto();
    
  }

  private guardarProducto(){
    //console.log(this.cliente)
    this.productoService.registrarProducto(this.producto).subscribe
    ({
      next:(respuesta)=> {
        this.respuesta = respuesta;
        console.log(respuesta)
        this.mensajeCorrecto = 'Producto '+this.producto.nombre+' creado correctamente';
        this.registroCreado = true;

      },error:(error : any)=>{
        console.log(error);
        this.mensajeError = 'Hubo un error al registrar el producto';
        //console.log(error);
        this.detalleError = error.error.error + error.error.mensaje;
      }
    }
    )
  }
  reiniciarFormulario() {
    this.producto = new Producto(); // Reiniciar el objeto cliente
    this.registroCreado = false; // Ocultar el botón
    //this.router.navigate(['/agregarFactura']); // Redirigir a la misma página
    window.location.reload();
  }

}
