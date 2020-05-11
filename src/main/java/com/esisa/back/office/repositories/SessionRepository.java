package com.esisa.back.office.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.Session;

public interface SessionRepository extends MongoRepository<Session, ObjectId> {
	public List<Session> findByClassRoomId(ObjectId id);
}
