package com.jeremy.prodandcat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jeremy.prodandcat.models.Category;
import com.jeremy.prodandcat.models.Product;
@Repository

public interface CategoryRepo extends CrudRepository<Category, Long> {
    List<Category> findAllByProducts(Product product);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Category> findByProductsNotContains(Product product);
}
