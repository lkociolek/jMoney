package dev.kociolek.jmoney.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dev.kociolek.jmoney.domain.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String>{

	User findByEmail(String username);

}
