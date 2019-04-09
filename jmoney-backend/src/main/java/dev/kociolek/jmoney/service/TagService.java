package dev.kociolek.jmoney.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kociolek.jmoney.domain.Tag;
import dev.kociolek.jmoney.repository.TagRepository;

@Service
public class TagService implements IService<Tag> {

	private TagRepository repository;

	@Autowired
	public TagService(TagRepository repository) {
		this.repository = repository;
	}

	@Override
	public Tag create(Tag tag) {
		return repository.save(tag);
	}

	@Override
	public Tag update(Tag tag) {
		return repository.save(tag);
	}

	@Override
	public void delete(Tag tag) {
		repository.delete(tag);
	}

	@Override
	public Optional<Tag> findById(String id) {
		return repository.findById(id);
	}

}
