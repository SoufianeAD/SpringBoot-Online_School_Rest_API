package com.esisa.back.office.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.School;

public interface SchoolRepository extends MongoRepository<School, Long> {
}
