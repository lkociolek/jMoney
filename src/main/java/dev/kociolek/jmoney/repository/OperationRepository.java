package dev.kociolek.jmoney.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dev.kociolek.jmoney.domain.operation.Operation;

@Repository
public interface OperationRepository extends PagingAndSortingRepository<Operation, String>{

}
