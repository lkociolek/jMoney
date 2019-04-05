package dev.kociolek.jmoney.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kociolek.jmoney.domain.operation.Transfer;
import dev.kociolek.jmoney.repository.TransferRepository;

@Service
public class TransferService implements IService<Transfer> {

	@Autowired
	TransferRepository repository;
	
	public TransferService(TransferRepository repository) {
		this.repository = repository;
	}

	@Override
	public Transfer create(Transfer transfer) {
		return repository.save(transfer);
	}

	@Override
	public Transfer update(Transfer transfer) {
		Transfer transferToUpdate = repository.findById(transfer.getId()).get();
		transferToUpdate.setAmount(transfer.getAmount());
		transferToUpdate.setIncomingAccount(transfer.getIncomingAccount());
		transferToUpdate.setOutcomingAccount(transfer.getOutcomingAccount());
		transferToUpdate.setOperationDetail(transfer.getOperationDetail());
		return repository.save(transferToUpdate);
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
