package com.esisa.back.office.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.Homework;

public interface HomeworkRepository extends MongoRepository<Homework, ObjectId> {
	public List<Homework> findByClassRoomId(ObjectId id);
}
