package com.example.bcsd.controller;

import com.example.bcsd.controller.dto.ArticleRequest;
import com.example.bcsd.model.Article;
import com.example.bcsd.service.ArticleService;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity
                .ok(articleService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Article> postArticle(@RequestBody ArticleRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(articleService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticleById(
            @PathVariable Long id, @RequestBody ArticleRequest request
    ) {
        return ResponseEntity
                .ok(articleService.updateById(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticleById(@PathVariable Long id) {
        articleService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
