package com.example.bcsd.service;

import com.example.bcsd.dto.request.ArticleCreateRequest;
import com.example.bcsd.dto.request.ArticleUpdateRequest;
import com.example.bcsd.dto.resopnse.ArticleResponse;
import com.example.bcsd.global.exception.CustomException;
import com.example.bcsd.global.exception.ExceptionMessage;
import com.example.bcsd.model.Article;
import com.example.bcsd.model.Board;
import com.example.bcsd.model.Member;
import com.example.bcsd.repository.ArticleRepository;
import com.example.bcsd.repository.BoardRepository;
import com.example.bcsd.validation.ArticleValidation;
import com.example.bcsd.validation.BoardValidation;
import com.example.bcsd.validation.MemberValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final BoardRepository boardRepository;
    private final ArticleValidation articleValidation;
    private final MemberValidation memberValidation;
    private final BoardValidation boardValidation;

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
        Member author = memberValidation.validateMemberExistAndGet(request.authorId());
        Board board = boardValidation.validateBoardExistAndGet(request.boardId());

        return ArticleResponse.fromEntity(
                articleRepository.save(
                        request.toEntity(author, board)
                )
        );
    }

    @Transactional
    public ArticleResponse updateArticleById(Long id, ArticleUpdateRequest request) {
        boardValidation.validateBoardExist(request.boardId());
        articleValidation.validateArticleExist(id);

        Article article = articleRepository
                .findById(id)
                .get()
                .updateDetails(boardRepository.findById(request.boardId()).get(), request.title(), request.content());

        return ArticleResponse.fromEntity(article);
    }

    @Transactional
    public void deleteArticleById(Long id) {
        Article article = articleValidation.validateArticleExistAndGet(id);

        articleRepository.delete(article);
    }
}
