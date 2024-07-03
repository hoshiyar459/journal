package com.journal.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.journal.Entity.User;

public interface UserEntryRepository extends MongoRepository<User , ObjectId> {
    User findByUsername(String UserName) ;
}
