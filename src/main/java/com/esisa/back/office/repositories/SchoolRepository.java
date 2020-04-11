package com.esisa.back.office.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.School;

public interface SchoolRepository extends MongoRepository<School, ObjectId> {
	public School findBy_id(ObjectId _id);
}
