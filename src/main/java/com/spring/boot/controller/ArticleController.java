package com.spring.boot.controller;


import com.spring.boot.model.Article;
import com.spring.boot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<Article> articles= articleService.getAllArticles();
        model.addAttribute("articles",articles);
        return  "articleList";
    }

    @GetMapping("/new-article")
    public String newArticle(){
        String url = "newArticle";
        return url;
    }

    @PostMapping("/new-article")
    @ResponseBody
    public String newArticlePost(Article article){
        String message ="";
        articleService.save(article);
        message="OK";
        return message;
    }
}
