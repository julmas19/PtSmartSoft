import { Component } from '@angular/core';
import { RouterOutlet ,RouterLink} from '@angular/router';
import { ListClienteComponent } from "./components/list-clientes/list-cliente.component";
import { ListProductoComponent } from './components/list-productos/list-producto.component';
import { AgregarClienteComponent } from './components/agregar-cliente/agregar-cliente.component';
import { AgregarProductoComponent } from './components/agregar-producto/agregar-producto.component';
import {FormsModule} from '@angular/forms'
import { ListFacturaComponent } from './components/list-facturas/list-factura.component';
import { AgregarFacturaComponent } from './components/agregar-factura/agregar-factura.component';
import { ListDetalleComponent } from './components/list-detalles/list-detalle.component';
import { AgregarDetalleComponent } from './components/agregar-detalle/agregar-detalle.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule,RouterOutlet, ListClienteComponent 
            ,ListFacturaComponent,ListProductoComponent,RouterLink
            ,AgregarClienteComponent,AgregarProductoComponent
            ,AgregarFacturaComponent,ListDetalleComponent
            ,AgregarDetalleComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'pt-smartsoft-front';
}
