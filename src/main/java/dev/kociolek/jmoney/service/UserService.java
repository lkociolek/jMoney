package dev.kociolek.jmoney.service;

import dev.kociolek.jmoney.domain.Role;
import dev.kociolek.jmoney.domain.User;
import dev.kociolek.jmoney.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IService<User>, UserDetailsService {

	private UserRepository repository;

	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public User create(User user) {
		return repository.save(user);
	}

	@Override
	public User update(User user) {
		return repository.save(user);
	}

	@Override
	public void delete(User user) {
		repository.delete(user);
	}

	@Override
	public Optional<User> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userByName = repository.findByName(username);
		if(userByName.isPresent()) {
			User user = userByName.get();
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(Role.ADMIN.name()));
			return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
		}
		throw new UsernameNotFoundException("Nie znaleziono użytkownika");
	}


}