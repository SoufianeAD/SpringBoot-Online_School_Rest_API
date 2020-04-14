package com.esisa.back.office.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.Professor;

public interface ProfessorRepository extends MongoRepository<Professor, ObjectId> {

}
