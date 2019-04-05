package dev.kociolek.jmoney.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kociolek.jmoney.domain.Account;
import dev.kociolek.jmoney.repository.AccountRepository;

@Service
public class AccountService implements IService<Account> {

	@Autowired
	AccountRepository repository;

	public AccountService(AccountRepository repository) {
		this.repository = repository;
	}

	@Override
	public Account create(Account account) {
		return repository.save(account);
	}

	@Override
	public Account update(Account account) {
		Account accountToUpdate = repository.findById(account.getId()).get();
		accountToUpdate.setName(account.getName());
		accountToUpdate.setBalance(account.getBalance());
		return repository.save(accountToUpdate);
	}

	@Override
	public void delete(Account account) {
		repository.delete(account);
	}

	@Override
	public Optional<Account> findById(String id) {
		return repository.findById(id);
	}

}
