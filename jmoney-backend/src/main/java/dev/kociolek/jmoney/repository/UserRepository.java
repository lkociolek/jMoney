package dev.kociolek.jmoney.repository;

import dev.kociolek.jmoney.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String>{
    Optional<User> findByName(String username);
}
