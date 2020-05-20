package com.esisa.back.office.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.ClassRoom;

public interface ClassRoomRepository extends MongoRepository<ClassRoom, Long> {
	public List<ClassRoom> findByLevelId(Long id);
}
