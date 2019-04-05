package dev.kociolek.jmoney.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kociolek.jmoney.domain.Category;
import dev.kociolek.jmoney.repository.CategoryRepository;

@Service
public class CategoryService implements IService<Category> {

	@Autowired
	CategoryRepository repository;

	public CategoryService(CategoryRepository repository) {
		this.repository = repository;
	}

	@Override
	public Category create(Category category) {
		return repository.save(category);
	}

	@Override
	public Category update(Category category) {
		Category categoryToUpdate = repository.findById(category.getId()).get();
		categoryToUpdate.setName(category.getName());
		categoryToUpdate.setAccount(category.getAccount());
		categoryToUpdate.setImage(category.getImage());
		categoryToUpdate.setParentCategory(category.getParentCategory());
		categoryToUpdate.setType(category.getType());
		return repository.save(categoryToUpdate);
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
