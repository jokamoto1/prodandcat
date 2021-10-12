package com.jeremy.prodandcat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeremy.prodandcat.models.Category;
import com.jeremy.prodandcat.models.Product;
import com.jeremy.prodandcat.repositories.ProductRepo;
@Service

public class ProductServ {
	@Autowired
	CategoryServ cServ;
	private final ProductRepo repo;

	public ProductServ(ProductRepo repo) {
		this.repo = repo;
	}

	public List<Product> findAll() {
		return (List<Product>) repo.findAll();
	}

	public Product create(Product product) {
		return repo.save(product);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

//
	public Product findOne(Long id) {
		Optional<Product> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	public Product addCatToProd(Long catId, Long prodId) {
		
		Product product = findOne(prodId);
		Category category = cServ.findOne(catId);
		product.getCategories().add(category);
		return repo.save(product);
	}
	public Product removeCatToProd(Long catId, Long prodId) {
		
		Product product = findOne(prodId);
		Category category = cServ.findOne(catId);
		product.getCategories().remove(category);
		return repo.save(product);
	}

}
