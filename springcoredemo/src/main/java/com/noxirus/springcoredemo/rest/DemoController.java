package com.noxirus.springcoredemo.rest;

import com.noxirus.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;

    // Dependency Injection Reference
    //The qualifier needs to be the name of the class, but in camel case
    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach theCoach,
                          @Qualifier("swimCoach") Coach theAnotherCoach){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    /*Setter injection, name does not need to be specific
    @Autowired
    public void setCoach(Coach theCoach){
        myCoach = theCoach;
    }

     */

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach = anotherCoach," + (myCoach == anotherCoach);
    }
}
