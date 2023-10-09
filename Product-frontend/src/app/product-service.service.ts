import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  private domain: string | undefined ;

  constructor(private http: HttpClient) {
    this.domain=environment.domain;
   }

  // recupere la liste des produits depuis l'api
  getProduct() {
    let url = `${this.domain}/products`;
    return this.http.get<any>(url);
  }



  // chercher un produit par le nom du categorie en utilisant l'api
  searchProducts(category: string): Observable<any[]> {
    let url = `${this.domain}/products/search?category=${category}`;
    return this.http.get<any[]>(url);
  }



}
