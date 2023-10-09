package com.med.productbackend.repository;

import com.med.productbackend.model.Category;
import com.med.productbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.category = :category AND p.quantity > 0")
    List<Product> findProductByCategoryAndQuantityGreaterThanZero(@Param("category") Category category);
}
