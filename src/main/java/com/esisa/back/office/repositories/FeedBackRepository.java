package com.esisa.back.office.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.FeedBack;

public interface FeedBackRepository extends MongoRepository<FeedBack, Long> {
	public List<FeedBack> findByHomeworkId(long id);
	public FeedBack findByHomeworkIdAndStudentId(long idHomework, long idStudent);
}
