package com.esisa.back.office.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.Homework;

public interface HomeworkRepository extends MongoRepository<Homework, Long> {
	public List<Homework> findByClassRoomId(long id);
}
