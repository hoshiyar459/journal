package com.journal.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.journal.Entity.JournalEntry;


public interface journalEntryRepository extends MongoRepository<JournalEntry , ObjectId>{
    
}
