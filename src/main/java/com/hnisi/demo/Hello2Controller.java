package com.hnisi.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello2Controller {

    @RequestMapping("/hello2")
    public String hello(){
        return "bbb";
    }
}
