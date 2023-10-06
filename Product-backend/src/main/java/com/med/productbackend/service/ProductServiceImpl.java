package com.med.productbackend.service;

import com.med.productbackend.model.Category;
import com.med.productbackend.model.Product;
import com.med.productbackend.repository.CategoryRepository;
import com.med.productbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Category addCategory(Category c) {
        return categoryRepository.save(c);
    }

    @Override
    public Product addProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Category getCategoryByName(String nc) {
        return categoryRepository.findByName(nc).get(0);
    }

    @Override
    public List<Product> searchProductByCategoryName(String cn) {
        List<Product> result = new ArrayList<>();
        List<Category> categories = categoryRepository.findByName(cn);

        for (Category c : categories) {
            for (Product p : c.getProducts()) {
                if (p.getQuantity() > 0) {
                    result.add(p);
                }
            }
        }
        return result;
    }
}
