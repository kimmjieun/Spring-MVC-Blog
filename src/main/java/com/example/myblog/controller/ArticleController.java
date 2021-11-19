package com.example.myblog.controller;

import com.example.myblog.dto.ArticleForm;
import com.example.myblog.entity.Article;
import com.example.myblog.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j // 로깅(logging) 기능 추가! Lombok 플러그인 설치 필요!
@RequiredArgsConstructor // final 필드 값을 알아서 가져옴! (@autowired 대체!)
@Controller // 컨트롤러 선언! 요청과 응답을 처리!
public class ArticleController {
    // 리파지터리 객체 자동 삽입 됨! 위에서 @RequiredArgsConstructor 했음!
    private final ArticleRepository articleRepository;


    @GetMapping("/articles") // 해당 요청을 처리하도록, 메소드를 등록!
    public String index(Model model) { // 모델 객체 가져옴
        // 모든 Article을 가져옴
        // Iterable 인터페이스는 ArrayList의 부모 인터페이스
        Iterable<Article> articleList = articleRepository.findAll();
        // 뷰 페이지로 articles 전달!
        model.addAttribute("articles", articleList);
        return "articles/index"; // 뷰페이지 설정
    }
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, // url의 {id} 값을 변수화!
                       Model model) {
        // id를 통해 Article을 가져옴!
        Article article = articleRepository.findById(id).orElse(null);
        // article을 뷰 페이지로 전달
        model.addAttribute("article", article);
        return "articles/show";
    }

    @GetMapping("/articles/new") // GET 요청이 해당 url로 오면, 아래 메소드를 수행!
    public String newArticle() {
        return "articles/new"; // 보여줄 뷰 페이지
    }

    @GetMapping("/articles/list") // GET 요청이 해당 url로 오면, 아래 메소드를 수행!
    public String articleList() {
        return "articles/list"; // 보여줄 뷰 페이지
    }

    @PostMapping("/articles") // Post 방식으로 "/articles" 요청이 들어오면 아래 메소드 수행
    public String create(ArticleForm form){ // 폼 태그의 데이터가 ArticleForm 객체로 만들어짐!
        log.info(form.toString()); // ArticleForm 객체 정보를 확인!
        return "redirect:/articles"; // 브라우저를 "articles" url로 보냄!
    }

    @GetMapping("/articles/edit/{id}")
    public String edit(@PathVariable Long id,
                       Model model) {
        Article target = articleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 Article이 없습니다.")
        );
        model.addAttribute("article", target);
        return "articles/edit";
    }

}