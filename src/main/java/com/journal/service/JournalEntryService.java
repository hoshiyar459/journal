package com.journal.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.journal.Entity.JournalEntry;
import com.journal.Repository.journalEntryRepository;

@Component
public class JournalEntryService {
    
  @Autowired
   private  journalEntryRepository journalEntryRepository;

   public void SaveEntry(JournalEntry journalEntry){ 
        journalEntryRepository.save(journalEntry); 
   }
   
   public List<JournalEntry> getAll(){
     return  journalEntryRepository.findAll(); 
   }
   public Optional<JournalEntry> findById(ObjectId id){
     return journalEntryRepository.findById(id);
   }

   public void DeleteById(ObjectId id){
       journalEntryRepository.deleteById(id);
   }

   

}
