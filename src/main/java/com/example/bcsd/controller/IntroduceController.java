package com.example.bcsd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/introduce")
public class IntroduceController {
    @GetMapping
    public String getIntroduce(
            @RequestParam(name = "name", defaultValue="이동훈", required = false) String name
    ) {
        return "안녕하세요 제 이름은 " + name + "입니다!";
    }
}
