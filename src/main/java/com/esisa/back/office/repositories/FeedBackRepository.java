package com.esisa.back.office.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.FeedBack;

public interface FeedBackRepository extends MongoRepository<FeedBack, ObjectId> {
	public List<FeedBack> findByHomeworkId(ObjectId id);
}
