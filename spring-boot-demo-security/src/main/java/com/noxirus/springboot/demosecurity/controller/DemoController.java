package com.noxirus.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
        return "home"; //This is the view name
    }

    @GetMapping("/leaders")
    public String showLeaders(){ return "leaders"; }

    @GetMapping("/systems")
    public String showSystems(){ return "systems"; }
}
