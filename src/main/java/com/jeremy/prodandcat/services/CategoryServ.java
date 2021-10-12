package com.jeremy.prodandcat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jeremy.prodandcat.models.Category;
import com.jeremy.prodandcat.repositories.CategoryRepo;
@Service

public class CategoryServ {
	private final CategoryRepo repo;

	public CategoryServ(CategoryRepo repo) {
		this.repo = repo;
	}

	public List<Category> findAll() {
		return (List<Category>) repo.findAll();
	}

	public Category create(Category category) {
		return repo.save(category);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

//
	public Category findOne(Long id) {
		Optional<Category> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

}
