package com.esisa.back.office.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.Absence;

public interface AbsenceRepository extends MongoRepository<Absence, Long> {
	public List<Absence> findByStudentId(long id);
}
