package com.example.bcsd.controller;

import com.example.bcsd.controller.dto.resopnse.ArticleViewResponse;
import com.example.bcsd.service.ArticleViewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class ArticleViewController {
    private final ArticleViewService articleViewService;

    public ArticleViewController(ArticleViewService articleViewService) {
        this.articleViewService = articleViewService;
    }

    @GetMapping
    public String getAllArticlesView(Model model) {
        List<ArticleViewResponse> articleList = articleViewService.getAllPostViews();

        model.addAttribute("articleList", articleList);

        return "post";
    }
}
