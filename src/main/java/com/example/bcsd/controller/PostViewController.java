package com.example.bcsd.controller;

import com.example.bcsd.model.Article;
import com.example.bcsd.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostViewController {
    private final ArticleService articleService;

    public PostViewController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public String getAllArticlesView(Model model) {
        List<Article> articles = articleService.getAllArticles();

        model.addAttribute("articleList", articles);

        return "post";
    }
}
