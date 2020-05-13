package com.esisa.back.office.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.Student;

public interface StudentRepository extends MongoRepository<Student, ObjectId> {

	public List<Student> findByLevelId(ObjectId objectId);
}
