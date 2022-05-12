package com.springboottutorials.springboottutorials.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class ThymeController
{
    @GetMapping("/about")
    public String about(Model model)
    {
        model.addAttribute("name","Dayyan Ali");
        model.addAttribute("currentDate", new Date());
        return "about";
    }

    @GetMapping("/example-loop")
    public String iterateHandler(Model model)
    {
        List<String> nameList = List.of("Kashif", "J.DOT", "Keanu", "Quratulain");
        model.addAttribute("names",nameList);
        return "iterate";
    }

    @GetMapping("/condition")
    public String conditionHandler(Model model)
    {
        model.addAttribute("isActive", true);
        model.addAttribute("gender","M");

        List<Integer> integerList = List.of(23,63);
        model.addAttribute("intList",integerList);

        return "condition";
    }

    @GetMapping("/fragment")
    public String fragmentHandler(Model model)
    {
        model.addAttribute("myTitle","This title is from CONTROLLER");
        return "fragment";
    }

    @GetMapping("/inherit")
    public String inheritHandler()
    {
        return "base";
    }

    @GetMapping("/about-new")
    public String newAbout()
    {
        return "aboutnew";
    }

    @GetMapping("/contact")
    public String contact()
    {
        return "contact";
    }
}
