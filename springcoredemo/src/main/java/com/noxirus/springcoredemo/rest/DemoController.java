package com.noxirus.springcoredemo.rest;

import com.noxirus.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    /* Dependency Injection Reference
    @Autowired
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }
     */

    //Setter injection, name does not need to be specific
    @Autowired
    public void setCoach(Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
