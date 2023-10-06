package com.med.productbackend.service;

import com.med.productbackend.model.Category;
import com.med.productbackend.model.Product;

import java.util.List;

public interface ProductService {

    Category addCategory(Category c);
    Product addProduct(Product p);
    List<Category> allCategories();
    List<Product> allProducts();
    Category getCategoryById(Long id);
    Product getProductById(Long id);
    void deleteCategory(Long id);
    void deleteProduct(Long id);
    Category getCategoryByName(String nc);
    List<Product> searchProductByCategoryName(String cn);



}
