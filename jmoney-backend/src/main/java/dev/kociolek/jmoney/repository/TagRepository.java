package dev.kociolek.jmoney.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dev.kociolek.jmoney.domain.Tag;

@Repository
public interface TagRepository extends PagingAndSortingRepository<Tag, String>{

}
