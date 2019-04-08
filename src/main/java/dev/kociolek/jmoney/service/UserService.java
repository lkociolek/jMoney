package dev.kociolek.jmoney.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kociolek.jmoney.domain.User;
import dev.kociolek.jmoney.repository.UserRepository;

@Service
public class UserService implements IService<User> {

	private static final Logger LOGGER = Logger.getLogger(UserService.class);
	private UserRepository repository;

	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public User create(User user) {
		LOGGER.info("User created");
		return repository.save(user);
	}

	@Override
	public User update(User user) {
		LOGGER.info("User updated");
		return repository.save(user);
	}

	@Override
	public void delete(User user) {
		LOGGER.info("User deleted");
		repository.delete(user);
	}

	@Override
	public Optional<User> findById(String id) {
		LOGGER.info("User founded");
		return repository.findById(id);
	}

}