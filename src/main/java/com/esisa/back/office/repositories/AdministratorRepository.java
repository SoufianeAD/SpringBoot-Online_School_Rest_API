package com.esisa.back.office.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.Administrator;


public interface AdministratorRepository extends MongoRepository<Administrator, Long> {

	public List<Administrator> findByAccountSchoolId(long id);
	public Administrator findByAccountUserNameAndAccountPassword(String username,String password);
}
