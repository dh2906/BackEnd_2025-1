package com.example.bcsd.controller;

import com.example.bcsd.dto.resopnse.ArticleViewResponse;
import com.example.bcsd.service.ArticleViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class ArticleViewController {
    private final ArticleViewService articleViewService;

    @GetMapping
    public String getAllArticlesView(Model model) {
        List<ArticleViewResponse> articleViewResponseList = articleViewService.getAllPostViews();

        Map<String, List<ArticleViewResponse>> ArticleListGroupByBoard = articleViewResponseList.stream()
                .collect(Collectors.groupingBy(ArticleViewResponse::board));

        model.addAttribute("articleListGroupByBoard", ArticleListGroupByBoard);

        return "post";
    }

    @GetMapping(params = "boardId")
    public String getAllArticlesViewByBoardId(Model model, @RequestParam Long boardId) {
        List<ArticleViewResponse> articleViewResponseList = articleViewService.getAllPostViewsByBoardId(boardId);

        model.addAttribute("articleList", articleViewResponseList);

        return "post";
    }
}
