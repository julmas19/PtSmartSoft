import { Factura } from "./factura";
import { Producto } from "./producto";

export class Detalle {
    num_detalle:number;
    factura:Factura;
    producto:Producto;
    cantidad:number;
    precio:number;

    constructor() {
        this.num_detalle = 0; 
        this.factura = new Factura(); // Inicializa un objeto Factura
        this.producto = new Producto(); // Inicializa un objeto Producto
        this.cantidad; 
        this.precio = 0; 
    }
}

