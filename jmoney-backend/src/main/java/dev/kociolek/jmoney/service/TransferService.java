package dev.kociolek.jmoney.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kociolek.jmoney.domain.operation.Transfer;
import dev.kociolek.jmoney.repository.TransferRepository;

@Service
public class TransferService implements IService<Transfer> {

	private TransferRepository repository;

	@Autowired
	public TransferService(TransferRepository repository) {
		this.repository = repository;
	}

	@Override
	public Transfer create(Transfer transfer) {
		return repository.save(transfer);
	}

	@Override
	public Transfer update(Transfer transfer) {
		return repository.save(transfer);
	}

	@Override
	public void delete(Transfer transfer) {
		repository.delete(transfer);
	}

	@Override
	public Optional<Transfer> findById(String id) {
		return repository.findById(id);
	}

}
