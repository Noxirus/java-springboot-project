package com.noxirus.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TrackCoach implements Coach {
    public TrackCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @PostConstruct
    public void startUp(){
        System.out.println("Track Coach starting up");
    }

    @PreDestroy
    public void shutDown(){
        System.out.println("Deactivating");
    }

    @Override
    public String getDailyWorkout() {
        return "Sit on the couch and eat Cheetos";
    }
}
