package com.esisa.back.office.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.ClassRoom;

public interface ClassRoomRepository extends MongoRepository<ClassRoom, ObjectId> {
	public List<ClassRoom> findBySchoolId(ObjectId id);
}
