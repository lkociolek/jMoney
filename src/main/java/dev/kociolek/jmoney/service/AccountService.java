package dev.kociolek.jmoney.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kociolek.jmoney.domain.Account;
import dev.kociolek.jmoney.repository.AccountRepository;

@Service
public class AccountService implements IService<Account> {

	private AccountRepository repository;

	@Autowired
	public AccountService(AccountRepository repository) {
		this.repository = repository;
	}

	@Override
	public Account create(Account account) {
		return repository.save(account);
	}

	@Override
	public Account update(Account account) {
		return repository.save(account);
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
