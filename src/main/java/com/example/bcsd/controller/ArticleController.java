package com.example.bcsd.controller;

import com.example.bcsd.controller.dto.ArticleRequest;
import com.example.bcsd.model.Article;
import com.example.bcsd.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        return ResponseEntity
                .ok(articleService.getAllArticles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        return ResponseEntity
                .ok(articleService.getArticleById(id));
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody ArticleRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(articleService.createArticle(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticleById(
            @PathVariable Long id, @RequestBody ArticleRequest request
    ) {
        return ResponseEntity
                .ok(articleService.updateArticleById(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticleById(@PathVariable Long id) {
        articleService.deleteArticleById(id);

        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Void> notFoundExceptionHandle() {
        return ResponseEntity.notFound().build();
    }

}
