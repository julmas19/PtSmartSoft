import { Component } from '@angular/core';
import { Cliente } from '../../models/cliente';
import { ClienteService } from '../../services/cliente.service';

import { error } from 'console';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms'

@Component({
  selector: 'app-agregar-cliente',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterOutlet,RouterLink],
  templateUrl: './agregar-cliente.component.html',
  styleUrl: './agregar-cliente.component.css'
})
export class AgregarClienteComponent {
  cliente:Cliente = new Cliente();
  mensajeError: string = ''; // Inicializamos con un valor vacío
  mensajeCorrecto: string = ''; // Inicializamos con un valor vacío
  //Valida que el registro se haya creado para inhabilitar los campos
  detalleError: any = ''; // Inicializamos con un valor vacío
  registroCreado:boolean; //Valida que el registro se haya creado para inhabilitar los campos

  constructor(private clienteService:ClienteService,private router:Router){}

  onSubmit(){
    this.mensajeCorrecto='';
    this.mensajeError='';
    this.guardarCliente();
    
  }

  private guardarCliente(){
    //console.log(this.cliente)
    this.clienteService.registrarCliente(this.cliente).subscribe
    ({
      next:(lamd)=>{
        this.mensajeCorrecto = 'Cliente '+this.cliente.id_cliente+' creado correctamente';
        this.registroCreado = true;

      },error:(error : any)=>{
        console.log(error);
        this.mensajeError = 'Hubo un error al registrar el cliente.';

        this.detalleError = error.error.error + ": "+error.error.mensaje;;
      }
    }
    )
  }
  reiniciarFormulario() {
    this.cliente = new Cliente(); // Reiniciar el objeto cliente
    this.registroCreado = false; // Ocultar el botón
    //this.router.navigate(['/agregarFactura']); // Redirigir a la misma página
    window.location.reload();
  }
}
