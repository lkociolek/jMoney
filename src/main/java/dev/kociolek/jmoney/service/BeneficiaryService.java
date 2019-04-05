package dev.kociolek.jmoney.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kociolek.jmoney.domain.Beneficiary;
import dev.kociolek.jmoney.repository.BeneficiaryRepository;

@Service
public class BeneficiaryService implements IService<Beneficiary> {

	@Autowired
	BeneficiaryRepository repository;
	
	public BeneficiaryService(BeneficiaryRepository repository) {
		this.repository = repository;
	}

	@Override
	public Beneficiary create(Beneficiary beneficiary) {
		return repository.save(beneficiary);
	}

	@Override
	public Beneficiary update(Beneficiary beneficiary) {
		Beneficiary beneficiaryToUpdate = repository.findById(beneficiary.getId()).get();
		beneficiaryToUpdate.setName(beneficiary.getName());
		return repository.save(beneficiaryToUpdate);
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
