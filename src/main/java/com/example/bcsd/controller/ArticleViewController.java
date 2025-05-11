package com.example.bcsd.controller;

import com.example.bcsd.dto.resopnse.ArticleViewResponse;
import com.example.bcsd.service.ArticleViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class ArticleViewController {
    private final ArticleViewService articleViewService;

    @GetMapping
    public String getAllArticlesView(Model model) {
        List<ArticleViewResponse> articleList = articleViewService.getAllPostViews();

        model.addAttribute("articleList", articleList);

        return "post";
    }
}
