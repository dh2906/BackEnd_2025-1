package com.example.bcsd.service;

import com.example.bcsd.dto.resopnse.ArticleViewResponse;
import com.example.bcsd.model.Article;
import com.example.bcsd.model.Board;
import com.example.bcsd.model.Member;
import com.example.bcsd.repository.ArticleRepository;
import com.example.bcsd.repository.BoardRepository;
import com.example.bcsd.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleViewService {
    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Map<String, List<ArticleViewResponse>> getAllPostViews() {
        List<Article> articles = articleRepository.findAll();

        return convertToViewResponse(articles);
    }

    @Transactional(readOnly = true)
    public Map<String, List<ArticleViewResponse>> getAllPostViewsByBoardId(Long boardId) {
        List<Article> articles = articleRepository.findAllByBoardId(boardId);

        return convertToViewResponse(articles);
    }

    private Map<String, List<ArticleViewResponse>> convertToViewResponse(List<Article> articles) {
        return
                articles.stream()
                        .map(article ->
                                ArticleViewResponse.fromEntity(
                                        article,
                                        memberRepository.findById(article.getAuthor().getId())
                                                .map(Member::getName)
                                                .orElse("알 수 없음"),
                                        boardRepository.findById(article.getBoard().getId())
                                                .map(Board::getName)
                                                .orElse("알 수 없음")
                                )
                        ).collect(Collectors.groupingBy(ArticleViewResponse::board));
    }
}
