package com.esisa.back.office.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.Level;

public interface LevelRepository extends MongoRepository<Level, Long> {
	public List<Level> findBySchoolId(long id);
}
