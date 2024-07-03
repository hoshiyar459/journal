package com.journal.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("health-check")
@RestController
public class Health_check {
    
    @GetMapping
    public String Healthcheck(){
        return "ok sucess";
    }
}
