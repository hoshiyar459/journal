package com.journal.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.journal.Entity.User;
import com.journal.Repository.UserEntryRepository;

@Component
public class UserEntryService {
    
    @Autowired
   private UserEntryRepository userEntryRepository  ;

   public List<User> getAll(){
      return userEntryRepository.findAll(); 
   }
   public void save(User user){
     userEntryRepository.save(user);
   }
   public Optional<User> findbyId(ObjectId id){
     return userEntryRepository.findById(id); 
   }
   public User findByUsername(String username){
     return userEntryRepository.findByUsername(username); 
   }
   public void delete(ObjectId id){
      userEntryRepository.deleteById(id); 
   }
}
