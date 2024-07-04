package com.journal.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.journal.Entity.JournalEntry;
import com.journal.Entity.User;
import com.journal.Repository.journalEntryRepository;

@Component
public class JournalEntryService {
    
  @Autowired
   private  journalEntryRepository journalEntryRepository;

   @Autowired
   private UserEntryService userEntryService ; 

   public void SaveEntry(JournalEntry journalEntry , String username){ 
       User user =  userEntryService.findByUsername(username); 
       JournalEntry Entry =  journalEntryRepository.save(journalEntry); 
       user.getJournalEntry().add(Entry); 
       userEntryService.save(user);
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

public void DeleteById(ObjectId myId, String username) {
    User user = userEntryService.findByUsername(username); 
    user.getJournalEntry().removeIf(x -> x.getId().equals(myId));
    userEntryService.SaveEntry(user);
    journalEntryRepository.deleteById(myId);
}

public void saveEntry(JournalEntry entry){
   journalEntryRepository.save(entry); 
}
}
