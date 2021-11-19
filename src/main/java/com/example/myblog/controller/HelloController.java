package com.example.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 해당 클래스를, 컨트롤러로 선언!
public class HelloController {

    @GetMapping("/") // 다음 url 요청을 받음 -> "/"를 보여줘 -> 아래 메소드를 수행!
    public String hello() {
        return "helloworld"; // helloworld.mustache 페이지를 반환!
    }

    @GetMapping("/greetings")
    public String greetings(){
        return "greetings";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
