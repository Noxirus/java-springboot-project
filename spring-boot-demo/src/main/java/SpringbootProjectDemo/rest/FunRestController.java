package SpringbootProjectDemo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${person.name}")
    private String personName;
    @Value("${company.name}")
    private String companyName;

    @GetMapping("/company-information")
    public String companyInfo(){
        return personName + " " + companyName;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello Worlds";
    }

    @GetMapping("/test")
    public String test(){
        return "This is a test of an endpoint";
    }

    @GetMapping("/test-two")
    public String testTwo(){
        return "This is a second test of an endpoint";
    }
}
