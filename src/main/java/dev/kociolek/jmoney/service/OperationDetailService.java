package dev.kociolek.jmoney.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kociolek.jmoney.domain.operation.OperationDetail;
import dev.kociolek.jmoney.repository.OperationDetailRepository;

@Service
public class OperationDetailService implements IService<OperationDetail> {

	private OperationDetailRepository repository;

	@Autowired
	public OperationDetailService(OperationDetailRepository repository) {
		this.repository = repository;
	}

	@Override
	public OperationDetail create(OperationDetail detail) {
		return repository.save(detail);
	}

	@Override
	public OperationDetail update(OperationDetail detail) {
		return repository.save(detail);
	}

	@Override
	public void delete(OperationDetail detail) {
		repository.delete(detail);
	}

	@Override
	public Optional<OperationDetail> findById(String id) {
		return repository.findById(id);
	}

}
