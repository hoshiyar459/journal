package com.journal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journal.Entity.User;
import com.journal.service.UserEntryService;

@RestController
@RequestMapping("user")
public class UserEntryController {
    
    @Autowired
    private UserEntryService userEntryService ; 

    @GetMapping
    public List<User> getall(){
        return userEntryService.getAll(); 
    }
    @GetMapping("{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username){
         User UserInDb = userEntryService.findByUsername(username);
         if(UserInDb != null){
             return new ResponseEntity<>(UserInDb , HttpStatus.FOUND); 
         } 
         return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }

    @PostMapping
    public  ResponseEntity<User> CreateEntry(@RequestBody User user){
        try{
        userEntryService.save(user); 
        return new ResponseEntity<>(user , HttpStatus.CREATED);
        } 
        catch(Exception e){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
        }
    }
    
    @PutMapping("{username}")
    public ResponseEntity<User> CreateEntry(@RequestBody User user , @PathVariable String username){
            User newUser = userEntryService.findByUsername(username);
            if(newUser != null){
                 newUser.setUsername(user.getUsername());
                 newUser.setPassword(user.getPassword());
                userEntryService.save(newUser);
                return new ResponseEntity<>(newUser, HttpStatus.CREATED); 
            } 
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }
    // LETS TEST YOUR CODE BABY 
}
