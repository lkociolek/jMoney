package dev.kociolek.jmoney.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import dev.kociolek.jmoney.domain.User;
import dev.kociolek.jmoney.repository.UserRepository;

public class UserService implements Service<User> {

	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User create(User user) {
		 return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		User u = userRepository.findById(user.getId()).get();
		return userRepository.save(u);
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

	@Override
	public Optional<User> findById(String id) {
		return userRepository.findById(id);
	}

}