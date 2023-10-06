package com.med.productbackend.controller;


import com.med.productbackend.model.Category;
import com.med.productbackend.model.Product;
import com.med.productbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.allProducts());
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories(){

        return ResponseEntity.ok(productService.allCategories());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getCategoryById(id));
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product p){
        return ResponseEntity.ok(productService.addProduct(p));
    }

    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@RequestBody Category c){
        return ResponseEntity.ok(productService.addCategory(c));
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam("category") String cn){
        return ResponseEntity.ok(productService.searchProductByCategoryName(cn));
    }

    // ajouter un produit a une catégorie donnée
    @PostMapping("/categories/{cn}")
    public ResponseEntity<Product> addProducts(@RequestBody Product product, @PathVariable String cn) {
        Category c = productService.getCategoryByName(cn);
        Product p = new Product(null, product.getName(), product.getQuantity(), product.getPrice(), c);
        List<Product> products = new ArrayList<>();
        if (c.getProducts() != null) {
            products.addAll(c.getProducts());
        }
        products.add(p);
        c.setProducts(products);
        return ResponseEntity.ok(productService.addProduct(p));
    }

    @DeleteMapping("/product/{id}")
    public HttpStatus deleteProductById(@PathVariable Long id) throws IOException {
        productService.deleteProduct(id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/category/{id}")
    public HttpStatus deleteCategoryById(@PathVariable Long id) throws IOException{
        productService.deleteCategory(id);
        return HttpStatus.OK;
    }


}
