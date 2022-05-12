package com.springboottutorials.springboottutorials;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController
{
    @ResponseBody
    @RequestMapping("/test")
    public String firstHandler()
    {
        int a=67;
        int b=60;
        int c=999;
        return "Just for testing "+(a+b+c);
    }
}
