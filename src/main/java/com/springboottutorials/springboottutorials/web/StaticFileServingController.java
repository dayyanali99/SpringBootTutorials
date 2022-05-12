package com.springboottutorials.springboottutorials.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticFileServingController
{
    @GetMapping("/static-example")
    public String example()
    {
        return "example";
    }
}
