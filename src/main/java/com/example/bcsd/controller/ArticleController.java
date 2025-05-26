package com.example.bcsd.controller;

import com.example.bcsd.dto.request.ArticleCreateRequest;
import com.example.bcsd.dto.request.ArticleUpdateRequest;
import com.example.bcsd.dto.resopnse.ArticleResponse;
import com.example.bcsd.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<ArticleResponse>> getAllArticles() {
        return ResponseEntity
                .ok(articleService.getAllArticles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> getArticleById(
            @PathVariable Long id
    ) {
        return ResponseEntity
                .ok(articleService.getArticleById(id));
    }

    @GetMapping(params = "boardId")
    public ResponseEntity<List<ArticleResponse>> getArticlesByBoardId(
            @RequestParam Long boardId
    ) {
        return ResponseEntity
                .ok(articleService.getArticlesByBoardId(boardId));
    }

    @PostMapping
    public ResponseEntity<ArticleResponse> createArticle(
            @RequestBody @Valid ArticleCreateRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(articleService.createArticle(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleResponse> updateArticleById(
            @PathVariable Long id,
            @RequestBody @Valid ArticleUpdateRequest request
    ) {
        return ResponseEntity
                .ok(articleService.updateArticleById(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticleById(
            @PathVariable Long id
    ) {
        articleService.deleteArticleById(id);

        return ResponseEntity.noContent().build();
    }
}
