package com.journal.Controller;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.journal.Entity.JournalEntry;
import com.journal.service.JournalEntryService;

import java.util.* ; 


@RequestMapping("journal")
@RestController
public class journalEntryController {

  @Autowired
  private JournalEntryService journalEntryService ; 

      @GetMapping
      public List<JournalEntry> getAll(JournalEntry journalEntry){
            return journalEntryService.getAll();
      }

      @GetMapping("id/{id}")
      public ResponseEntity<JournalEntry> findById(@PathVariable ObjectId id ){
          JournalEntry entry =   journalEntryService.findById(id).orElse(null); 
          if(entry != null){
             return new ResponseEntity<>(entry , HttpStatus.FOUND); 
          }
          else {
             return new  ResponseEntity<>(HttpStatus.NOT_FOUND); 
          }
      }

      @PostMapping
      public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry journalEntry){
        try {
          journalEntryService.SaveEntry(journalEntry);
          return new ResponseEntity<>(journalEntry , HttpStatus.CREATED); 
        }
         catch (Exception e) {
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
        }
  
      }

      @DeleteMapping("id/{MyId}")
      public ResponseEntity<?>  deleJournalEntryById(@PathVariable ObjectId MyId){
        try{
          journalEntryService.DeleteById(MyId); 
          return new ResponseEntity<>( HttpStatus.NO_CONTENT) ; 
        } catch(Exception e ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
        }
      }

      @PutMapping("id/{MyId}")
public ResponseEntity<JournalEntry> updateEntry(@PathVariable ObjectId MyId , @RequestBody JournalEntry newJournalEntry){
     
    JournalEntry oldEntry =  journalEntryService.findById(MyId).orElse(null); 

    if(oldEntry != null){
        if(newJournalEntry.getTitle() != null && !newJournalEntry.getTitle().trim().isEmpty()){
            oldEntry.setTitle(newJournalEntry.getTitle());
        }
        if(newJournalEntry.getContent() != null && !newJournalEntry.getContent().trim().isEmpty()){
            oldEntry.setContent(newJournalEntry.getContent());
        }
        journalEntryService.SaveEntry(oldEntry);
        return new ResponseEntity<>(oldEntry , HttpStatus.OK); 
    }
    else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }
}
}
