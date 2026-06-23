import { Injectable } from '@angular/core';

export interface productos {

  nombre: string;
  precio: number;
  stock:  number;
  cantidad: number;

}

export interface listaItemsModel{

  productoId : number;
  cantidad : number;
}


@Injectable({
  providedIn: 'root',
})
export class ProductoModel {}
