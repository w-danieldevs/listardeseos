import { Component, OnInit } from '@angular/core';
import { ProductoService } from './feature/listaDeseos/service/producto-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.scss'
})
export class App implements OnInit {

   productos: any[] = [];

  constructor(
    private productoService: ProductoService
  ) {}

  ngOnInit(): void {
    this.cargarProductos();
  }

  cargarProductos(): void {
    this.productoService.getProducto()
      .subscribe({
       next: (data) => {
  console.log('productos recibidos:', data);
  this.productos = data;
},
        error: (err) => {
          console.error(err);
        }
      });
    }
    
}
