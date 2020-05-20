package com.esisa.back.office.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.Document;

public interface DocumentRepository extends MongoRepository<Document, Long> {
	public List<Document> findByClassRoomId(long id);
}
