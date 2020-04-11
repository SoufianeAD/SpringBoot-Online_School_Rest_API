package com.esisa.back.office.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.ClassRoom;

public interface ClassRoomRepository extends MongoRepository<ClassRoom, ObjectId> {

}
