package com.login.controller;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;

public class HelloWorldController {  
    public ModelAndView helloWorld() {  
        String message = "HELLO SPRING MVC HOW R U";  
        return new ModelAndView("index", "message", message);  
    }
	
}  