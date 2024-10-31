import { Routes } from '@angular/router';
import path from 'path';
import { ListProductoComponent } from './components/list-productos/list-producto.component';
import { ListClienteComponent } from './components/list-clientes/list-cliente.component';
import { AgregarClienteComponent } from './components/agregar-cliente/agregar-cliente.component';
import { AgregarProductoComponent } from './components/agregar-producto/agregar-producto.component';
import { ListFacturaComponent } from './components/list-facturas/list-factura.component';
import { AgregarFacturaComponent } from './components/agregar-factura/agregar-factura.component';
import { ListDetalleComponent } from './components/list-detalles/list-detalle.component';
import { AgregarDetalleComponent } from './components/agregar-detalle/agregar-detalle.component';
import { InicioComponent } from './components/inicio/inicio.component';
export const routes: Routes = [
    {path:'inicio',component:InicioComponent},
    {path:'',redirectTo:'inicio',pathMatch:'full'},
    {path:'productos',component:ListProductoComponent},
    {path:'agregarProducto',component:AgregarProductoComponent},
    {path:'clientes',component:ListClienteComponent},
    {path:'agregarCliente',component:AgregarClienteComponent},
    {path:'facturas',component:ListFacturaComponent},
    {path:'agregarFactura',component:AgregarFacturaComponent},
    {path:'detalles',component:ListDetalleComponent},
    {path:'agregarDetalle',component:AgregarDetalleComponent},


];
