package com.journal.Entity;

import java.util.ArrayList;


import java.util.* ; 
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.annotation.Nonnull;
import lombok.Data;


@Document(collection = "user")
@Data
public class User {
    
    @Id
    private ObjectId Id ;
    
     @Nonnull
     @Indexed(unique = true)
    private String username; 

    @Nonnull
    private String Password ; 

    @DBRef
    private List<JournalEntry> journalEntry = new ArrayList<>(); 
}
