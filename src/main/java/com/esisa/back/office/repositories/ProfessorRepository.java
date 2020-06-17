package com.esisa.back.office.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.Professor;


public interface ProfessorRepository extends MongoRepository<Professor, Long> {

	public List<Professor> findByAccountSchoolId(long id);
	public Professor findByAccountUserNameAndAccountPassword(String username,String password);
}
