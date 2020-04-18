package com.esisa.back.office.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.Administrator;


public interface AdministratorRepository extends MongoRepository<Administrator, ObjectId> {

	/* Oussama Repository */
	public List<Administrator> findByAccountSchoolId(ObjectId objectId);
	public Administrator findByAccountUserNameAndAccountPassword(String username,String password);
}
