package com.noxirus.springcoredemo.config;

import com.noxirus.springcoredemo.common.Coach;
import com.noxirus.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
