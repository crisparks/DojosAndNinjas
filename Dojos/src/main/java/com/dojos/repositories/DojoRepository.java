package com.dojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojos.models.Dojo;

@Repository

public interface DojoRepository extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();
}