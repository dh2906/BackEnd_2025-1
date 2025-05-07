package com.example.bcsd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/introduce")
public class IntroduceController {
    @GetMapping
    public String getIntroduce(
            @RequestParam(name = "name", defaultValue="이동훈", required = false) String name,
            Model model
    ) {
        model.addAttribute("name" , name);

        return "hello";
    }
}
