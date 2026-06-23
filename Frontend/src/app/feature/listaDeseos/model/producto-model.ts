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

export interface ListaItemModel {
  id: number;
  cantidad: number;
  producto: ProductoModel;
}

export interface ProductoModel {
  id: number;
  nombre: string;
  precio: number;
  stock: number;
}


@Injectable({
  providedIn: 'root',
})
export class ProductoModel {}
