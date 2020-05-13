package com.esisa.back.office.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.Level;

public interface LevelRepository extends MongoRepository<Level, ObjectId> {
	public List<Level> findBySchoolId(ObjectId id);
}
