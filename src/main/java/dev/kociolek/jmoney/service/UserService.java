package dev.kociolek.jmoney.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kociolek.jmoney.domain.User;
import dev.kociolek.jmoney.repository.UserRepository;

@Service
public class UserService implements IService<User> {

	@Autowired
	private UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public User create(User user) {
		 return repository.save(user);
	}

	@Override
	public User update(User user) {
		User userToUpdate = repository.findById(user.getId()).get();
		userToUpdate.setName(user.getName());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setRoles(user.getRoles());
		return repository.save(userToUpdate);
	}

	@Override
	public void delete(User user) {
		repository.delete(user);
	}

	@Override
	public Optional<User> findById(String id) {
		return repository.findById(id);
	}

}