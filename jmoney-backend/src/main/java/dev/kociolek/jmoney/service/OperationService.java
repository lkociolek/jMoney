package dev.kociolek.jmoney.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kociolek.jmoney.domain.operation.Operation;
import dev.kociolek.jmoney.repository.OperationRepository;

@Service
public class OperationService implements IService<Operation> {

	private OperationRepository repository;

	@Autowired
	public OperationService(OperationRepository repository) {
		this.repository = repository;
	}

	@Override
	public Operation create(Operation operation) {
		return repository.save(operation);
	}

	@Override
	public Operation update(Operation operation) {
		return repository.save(operation);
	}

	@Override
	public void delete(Operation operation) {
		repository.delete(operation);
	}

	@Override
	public Optional<Operation> findById(String id) {
		return repository.findById(id);
	}

}
