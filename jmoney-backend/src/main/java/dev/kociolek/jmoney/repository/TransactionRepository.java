package dev.kociolek.jmoney.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dev.kociolek.jmoney.domain.operation.Transaction;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, String>{

}