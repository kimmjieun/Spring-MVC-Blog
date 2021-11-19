package com.example.myblog.controller;

import com.example.myblog.dto.ArticleForm;
import com.example.myblog.entity.Article;
import com.example.myblog.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ArticleApiController {
    @Autowired // 리파지터리 객체를 알아서 가져옴! 자바는 new ArticleRepository() 해야 했음!
    private ArticleRepository articleRepository;

    @PostMapping("/api/articles") // Post 요청이 "/api/articles" url로 온다면, 메소드 수행!
    public Long create(@RequestBody ArticleForm form) { // JSON 데이터를 받아옴!

        log.info(form.toString()); // 받아온 데이터 확인!

        // dto(데이터-전달-객체)를 entity(db-저장-객체)로 변경
        Article article = form.toEntity();

        // 리파지터리에게(db-관리-객체) 전달
        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        // 저장 엔티티의 id(PK)값 반환!
        return saved.getId();
    }
}