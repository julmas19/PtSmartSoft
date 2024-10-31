import { Component } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { CommonModule, DatePipe } from '@angular/common';
import {FormsModule} from '@angular/forms'
import { DetalleService } from '../../services/detalle.service';
import { Detalle } from '../../models/detalle';

@Component({
  selector: 'app-agregar-detalle',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterOutlet,RouterLink],
  templateUrl: './agregar-detalle.component.html',
  styleUrl: './agregar-detalle.component.css'
})
export class AgregarDetalleComponent {
  detalle:Detalle = new Detalle();
  mensajeError: string = ''; // Inicializamos con un valor vacío
  mensajeCorrecto: string = ''; // Inicializamos con un valor vacío
  idCliente:number;
  respuesta:any;
  detalleError: any = ''; // Inicializamos con un valor vacío
  num_factura:number;
  num_detalle:number;
  fecha_factura:Date
  registroCreado:boolean; //Valida que el registro se haya creado para inhabilitar los campos

  constructor(private detalleService:DetalleService,private router:Router){}

  onSubmit(){
    this.mensajeCorrecto='';
    this.mensajeError='';
    this.guardarProducto();
    
  }

  private guardarProducto(){
    console.log(this.detalle)
    this.detalleService.registrarDetalle(this.detalle,this.num_factura).subscribe
    ({
      next:(respuesta: any)=> {
        this.respuesta = respuesta;
        console.log(this.respuesta)
        const numeroFactura = respuesta.factura.num_factura;
        this.num_detalle = respuesta.num_detalle;
        this.num_factura = numeroFactura;
        this.mensajeCorrecto = 'Detalle '+this.num_detalle+' asociado a Factura '+numeroFactura +' creado correctamente';
        this.registroCreado = true;
        
        //this.router.navigate(['/clientes']);

      },error:(error : any)=>{
        console.log(error.error);
        this.mensajeError = 'Hubo un error al registrar el Detalle.';
        this.detalleError = error.error.error;
      }
    }
    )
  }
  reiniciarFormulario() {
    this.detalle = new Detalle(); // Reiniciar el objeto cliente
    this.registroCreado = false; // Ocultar el botón
    //this.router.navigate(['/agregarFactura']); // Redirigir a la misma página
    window.location.reload();
  }
}
