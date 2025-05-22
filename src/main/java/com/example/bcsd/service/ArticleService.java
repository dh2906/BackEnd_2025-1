package com.example.bcsd.service;

import com.example.bcsd.dto.request.ArticleCreateRequest;
import com.example.bcsd.dto.request.ArticleUpdateRequest;
import com.example.bcsd.dto.resopnse.ArticleResponse;
import com.example.bcsd.exception.CustomException;
import com.example.bcsd.exception.ExceptionMessage;
import com.example.bcsd.model.Article;
import com.example.bcsd.repository.ArticleRepository;
import com.example.bcsd.validation.ArticleValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final ArticleValidation articleValidation;

    @Transactional(readOnly = true)
    public List<ArticleResponse> getAllArticles() {
        return articleRepository.findAll()
                .stream()
                .map(ArticleResponse::fromEntity)
                .toList();
    }

    @Transactional(readOnly = true)
    public ArticleResponse getArticleById(Long id) {
        return ArticleResponse.fromEntity(
                articleRepository.findById(id)
                        .orElseThrow(() ->
                                new CustomException(ExceptionMessage.ARTICLE_NOT_FOUND)
                        )
        );
    }

    @Transactional(readOnly = true)
    public List<ArticleResponse> getArticlesByBoardId(Long boardId) {
        return articleRepository.findAllByBoardId(boardId)
                .stream()
                .map(ArticleResponse::fromEntity)
                .toList();
    }

    @Transactional
    public ArticleResponse createArticle(ArticleCreateRequest request) {
        articleValidation.validateArticleReference(request.authorId(), request.boardId());

        return ArticleResponse.fromEntity(
                articleRepository.save(
                        request.toEntity()
                )
        );
    }

    @Transactional
    public ArticleResponse updateArticleById(Long id, ArticleUpdateRequest request) {
        articleValidation.validateArticleReference(request.authorId(), request.boardId());
        articleValidation.validateArticleExist(id);

        Article article = articleRepository
                .findById(id)
                .get()
                .updateDetails(request.authorId(), request.boardId(), request.title(), request.content());

        return ArticleResponse.fromEntity(
                articleRepository.save(id, article)
        );
    }

    @Transactional
    public void deleteArticleById(Long id) {
        articleValidation.validateArticleExist(id);

        articleRepository.delete(id);
    }
}
