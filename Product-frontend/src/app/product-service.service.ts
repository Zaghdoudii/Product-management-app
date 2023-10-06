import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  constructor(private http: HttpClient) { }

  // recupere la liste des produits depuis l'api
  getProduct() {
    let url = `http://localhost:8080/products`;
    return this.http.get<any>(url);
  }



  // chercher un produit par le nom du categorie en utilisant l'api
  searchProducts(category: string): Observable<any[]> {
    let url = `http://localhost:8080/products/search?category=${category}`;
    return this.http.get<any[]>(url);
  }



}
