package dev.kociolek.jmoney.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kociolek.jmoney.domain.operation.Transaction;
import dev.kociolek.jmoney.repository.TransactionRepository;

@Service
public class TransactionService implements IService<Transaction> {

	@Autowired
	TransactionRepository repository;
	
	public TransactionService(TransactionRepository repository) {
		this.repository = repository;
	}

	@Override
	public Transaction create(Transaction transaction) {
		return repository.save(transaction);
	}

	@Override
	public Transaction update(Transaction transaction) {
		Transaction transactionToUpdate = repository.findById(transaction.getId()).get();
		transactionToUpdate.setAmount(transaction.getAmount());
		transactionToUpdate.setCategory(transaction.getCategory());
		transactionToUpdate.setOperation(transaction.getOperation());
		return repository.save(transactionToUpdate);
	}

	@Override
	public void delete(Transaction transaction) {
		repository.delete(transaction);
	}

	@Override
	public Optional<Transaction> findById(String id) {
		return repository.findById(id);
	}

}
