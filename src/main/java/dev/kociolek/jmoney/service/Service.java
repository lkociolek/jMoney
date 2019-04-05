package dev.kociolek.jmoney.service;

import java.util.Optional;

public interface Service<T> {
	T create(T entity);
	T update(T entity);
	void delete(T entity);
	Optional<T> findById(String id);
}
