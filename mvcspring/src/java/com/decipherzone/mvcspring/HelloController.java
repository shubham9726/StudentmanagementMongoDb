package com.decipherzone.mvcspring;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {
    public ModelAndView hello() {
        String message = "HELLO SPRING MVC HOW R U";
        return new ModelAndView("hello", "message", message);
    }
}