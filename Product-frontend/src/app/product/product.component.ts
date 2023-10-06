import { ProductServiceService } from './../product-service.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  public productList: Array<any> = [];
  category: string = '';
  products: any[] = [];

  constructor(private productService: ProductServiceService) { }

  ngOnInit(): void {
    this.getProduct();
    this.searchProducts();
  }



// recuperer la liste des produit en appelant le service ProductService
  getProduct() {
    this.productService.getProduct().subscribe(
      result => {
        this.productList = result;
        console.log(result);
      }
    )
  }


// effectue une recherche de produit en utilisant le service productService
  searchProducts() {
    this.productService.searchProducts(this.category).subscribe((response: any[]) => {
      this.products = response;
    });
  }



}
