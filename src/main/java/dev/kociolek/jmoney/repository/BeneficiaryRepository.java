package dev.kociolek.jmoney.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dev.kociolek.jmoney.domain.Beneficiary;

@Repository
public interface BeneficiaryRepository extends PagingAndSortingRepository<Beneficiary, String>{

}
