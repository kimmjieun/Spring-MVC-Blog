package com.example.myblog.dto;

import com.example.myblog.entity.Article;
import lombok.Data;

@Data // 생성자(디폴트, All), 게터, 세터, toString 등 다 만들어 줌!
public class ArticleForm {
    private String title;
    private String content;

    // 빌더 패턴으로 객체 생성! 생성자의 변형. 입력 순서가 일치하지 않아도 됨.
    public Article toEntity() {
        return Article.builder()
                .id(null)
                .title(title)
                .content(content)
                .build();
    }
}
