import { Component } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { CommonModule, DatePipe } from '@angular/common';
import {FormsModule} from '@angular/forms'
import { Factura } from '../../models/factura';
import { FacturaService } from '../../services/factura.service';

@Component({
  selector: 'app-agregar-factura',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterOutlet,RouterLink],
  templateUrl: './agregar-factura.component.html',
  styleUrl: './agregar-factura.component.css'
})
export class AgregarFacturaComponent {
  factura:Factura = new Factura();
  mensajeError: string = ''; // Inicializamos con un valor vacío
  mensajeCorrecto: string = ''; // Inicializamos con un valor vacío
  idCliente:number;
  respuesta:any;
  detalleError: any = ''; // Inicializamos con un valor vacío
  num_factura:string;
  fecha_factura:Date
  registroCreado:boolean; //Valida que el registro se haya creado para inhabilitar los campos

  constructor(private facturaService:FacturaService,private router:Router){}

  onSubmit(){
    this.mensajeCorrecto='';
    this.mensajeError='';
    this.guardarFactura();
    
  }

  private guardarFactura(){
    //console.log(this.cliente)
    this.facturaService.registrarFactura(this.factura,this.idCliente).subscribe
    ({
      next:(respuesta: any)=> {
        this.respuesta = respuesta;
        const numeroFactura = respuesta.num_factura;
        this.num_factura = respuesta.num_factura;
        this.fecha_factura = respuesta.fecha;
        this.mensajeCorrecto = 'Factura '+numeroFactura+' creada correctamente';
        this.registroCreado = true;

      },error:(error : any)=>{
        //console.log(error);
        this.mensajeError = 'Hubo un error al registrar La factura.';
        this.detalleError = error.error.error;
      }
    }
    )
  }
  reiniciarFormulario() {
    this.factura = new Factura(); // Reiniciar el objeto cliente
    this.registroCreado = false; // Ocultar el botón
    //this.router.navigate(['/agregarFactura']); // Redirigir a la misma página
    window.location.reload();
  }
}
