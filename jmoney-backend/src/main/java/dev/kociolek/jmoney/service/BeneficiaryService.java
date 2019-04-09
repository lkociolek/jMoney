package dev.kociolek.jmoney.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kociolek.jmoney.domain.Beneficiary;
import dev.kociolek.jmoney.repository.BeneficiaryRepository;

@Service
public class BeneficiaryService implements IService<Beneficiary> {

	private BeneficiaryRepository repository;

	@Autowired
	public BeneficiaryService(BeneficiaryRepository repository) {
		this.repository = repository;
	}

	@Override
	public Beneficiary create(Beneficiary beneficiary) {
		return repository.save(beneficiary);
	}

	@Override
	public Beneficiary update(Beneficiary beneficiary) {
		return repository.save(beneficiary);
	}

	@Override
	public void delete(Beneficiary beneficiary) {
		repository.delete(beneficiary);
	}

	@Override
	public Optional<Beneficiary> findById(String id) {
		return repository.findById(id);
	}

}
