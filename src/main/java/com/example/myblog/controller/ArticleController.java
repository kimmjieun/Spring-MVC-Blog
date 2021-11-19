package com.example.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러 선언! 요청과 응답을 처리!
public class ArticleController {
    @GetMapping("/articles") // 해당 요청을 처리하도록, 메소드를 등록!
    public String index(Model model) { // 모델 객체 가져옴
        // 데이터를 모델에 등록! 등록된 데이터는 뷰 페이지에서 사용 가능!
        // key(변수명): "msg",
        // value(내용): "안녕하세요, 반갑습니다!"
        model.addAttribute("msg", "안녕하세요, 반갑습니다!");
        return "articles/index"; // 뷰페이지 설정
    }

    @GetMapping("/articles/new") // GET 요청이 해당 url로 오면, 아래 메소드를 수행!
    public String newArticle() {
        return "articles/new"; // 보여줄 뷰 페이지
    }

    @GetMapping("/articles/list") // GET 요청이 해당 url로 오면, 아래 메소드를 수행!
    public String articleList() {
        return "articles/list"; // 보여줄 뷰 페이지
    }
}