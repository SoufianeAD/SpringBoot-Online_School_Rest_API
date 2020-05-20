package com.esisa.back.office.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.Student;

public interface StudentRepository extends MongoRepository<Student, Long> {

	public List<Student> findByLevelId(long id);
}
