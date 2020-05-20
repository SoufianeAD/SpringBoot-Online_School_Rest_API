package com.esisa.back.office.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.Session;

public interface SessionRepository extends MongoRepository<Session, Long> {
	public List<Session> findByClassRoomId(long id);
}
