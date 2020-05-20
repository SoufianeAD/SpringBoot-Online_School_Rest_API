package com.esisa.back.office.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.esisa.back.office.entities.Account;

public interface AccountRepository extends MongoRepository<Account, Long> {
}
