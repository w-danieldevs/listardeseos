import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { ProductoService } from './feature/listaDeseos/service/producto-service';
import { ListaItems } from './feature/listaDeseos/service/lista-items';
import { listaItemsModel } from './feature/listaDeseos/model/producto-model';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.scss'
})
export class App implements OnInit {

   productos: any[] = [];

  constructor(
    private productoService: ProductoService,
    private listaItems:   ListaItems,
    private cdr: ChangeDetectorRef,

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
  this.cdr.detectChanges();
},
        error: (err) => {
          console.error(err);
        }
      });
    } 

  AgregarProductos(productoId: number): void {

     console.log("ID enviado:", productoId);

  const request: listaItemsModel = {
    productoId,
    cantidad: 1
  };

  this.listaItems
      .agregarItem(request)
      .subscribe({
        next: (response) => {
          alert(response.message);
        },
        error: (error) => {
          console.error(error);
        }
      });
}
    
    
}
