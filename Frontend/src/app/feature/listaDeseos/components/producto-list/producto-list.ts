import { Component, Input } from '@angular/core';
import { ListaItems } from '../../service/lista-items';
import {  ListaItemModel, listaItemsModel, ProductoModel, productos } from '../../model/producto-model';

@Component({
  selector: 'app-producto-list',
  standalone: false,
  templateUrl: './producto-list.html',
  styleUrl: './producto-list.scss',
})
export class ProductoList {

@Input()
  items: ListaItemModel[] = [];

  constructor(
    private listaItemsService: ListaItems,
  ){}

  agregar(productoId: number) {

  const request: listaItemsModel = {
    productoId: productoId,
    cantidad: 1
  };

  this.listaItemsService.agregarItem(request).subscribe({
    next: (response) => {
      console.log(response);
      alert(response.message);
    },
    error: (error) => {
      console.log(error);
    }
  });
}
}
