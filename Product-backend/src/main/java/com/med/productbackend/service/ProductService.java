package com.med.productbackend.service;

import com.med.productbackend.model.Category;
import com.med.productbackend.model.Product;

import java.util.List;

public interface ProductService {

    List<Category> allCategories();
    List<Product> allProducts();
    Category getCategoryById(Long id);
    Product getProductById(Long id);
    Category addCategory(Category c);
    Product addProduct(Product p);
    void deleteCategory(Long id);
    void deleteProduct(Long id);
    Category getCategoryByName(String nc);
    List<Product> searchProductByCategoryName(String cn);



}
