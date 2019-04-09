package dev.kociolek.jmoney.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dev.kociolek.jmoney.domain.operation.Transfer;

@Repository
public interface TransferRepository extends PagingAndSortingRepository<Transfer, String> {

}