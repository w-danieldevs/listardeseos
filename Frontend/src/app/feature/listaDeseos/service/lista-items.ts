import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {  listaItemsModel } from '../model/producto-model';

@Injectable({
  providedIn: 'root',
})
export class ListaItems {

  private apiUrl ='http://localhost:8080/lista-items';

  constructor(
    private http: HttpClient
  ){}

  agregarItem( request : listaItemsModel): Observable <any> {
    return this.http.post(this.apiUrl, request);
  }

  getItems( ): Observable <any> {
    return this.http.get(this.apiUrl);
  }

}
