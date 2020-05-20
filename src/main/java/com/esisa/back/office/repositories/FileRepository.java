package com.esisa.back.office.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.File;

public interface FileRepository extends MongoRepository<File, Long> {
	
	public List<File> findByDocumentId(long id);
}
