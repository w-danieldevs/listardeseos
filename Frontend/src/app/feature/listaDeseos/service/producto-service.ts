import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { productos } from '../model/producto-model';

@Injectable({
  providedIn: 'root',
})
export class ProductoService {

private API_URL='http://localhost:8080/productos/get-productos';

constructor(private http: HttpClient){}

getProducto(): Observable<productos[]> {
  return this.http.get<productos[]>(this.API_URL);
}

}
