package dev.kociolek.jmoney.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kociolek.jmoney.domain.Category;
import dev.kociolek.jmoney.repository.CategoryRepository;

@Service
public class CategoryService implements IService<Category> {

	private CategoryRepository repository;

	@Autowired
	public CategoryService(CategoryRepository repository) {
		this.repository = repository;
	}

	@Override
	public Category create(Category category) {
		return repository.save(category);
	}

	@Override
	public Category update(Category category) {
		return repository.save(category);
	}

	@Override
	public void delete(Category category) {
		repository.delete(category);
	}

	@Override
	public Optional<Category> findById(String id) {
		return repository.findById(id);
	}

}
