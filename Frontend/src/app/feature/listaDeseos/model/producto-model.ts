import { Injectable } from '@angular/core';

export interface productos {

  nombre: string;
  precio: number;
  stock:  number;
  cantidad: number;

}


@Injectable({
  providedIn: 'root',
})
export class ProductoModel {}
