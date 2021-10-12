package com.jeremy.prodandcat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jeremy.prodandcat.models.Category;
import com.jeremy.prodandcat.models.Product;
@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{
//	 List<Product> findAllProdByCat(Category category);
List<Product> findAll();
}
