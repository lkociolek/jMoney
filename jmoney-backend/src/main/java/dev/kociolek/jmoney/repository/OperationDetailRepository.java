package dev.kociolek.jmoney.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dev.kociolek.jmoney.domain.operation.OperationDetail;

@Repository
public interface OperationDetailRepository extends PagingAndSortingRepository<OperationDetail, String>{

}
