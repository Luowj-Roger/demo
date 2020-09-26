package com.hnisi.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Vector;

@RestController
public class HelloController {

    @RequestMapping("/hello1")
    public String hello(){
        return "cccc";
    }
}
