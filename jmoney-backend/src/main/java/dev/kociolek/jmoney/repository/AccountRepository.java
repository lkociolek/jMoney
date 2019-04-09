package dev.kociolek.jmoney.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dev.kociolek.jmoney.domain.Account;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, String>{

}
