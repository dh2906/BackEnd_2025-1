package com.example.bcsd.controller;

import com.example.bcsd.model.Article;
import com.example.bcsd.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        Article response = articleService.getArticleById(id);

        return ResponseEntity.ok(response);
    }

}
