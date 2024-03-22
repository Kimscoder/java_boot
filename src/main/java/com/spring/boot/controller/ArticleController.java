package com.spring.boot.controller;


import com.spring.boot.model.Article;
import com.spring.boot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Article article = articleService.findById(id);
        model.addAttribute("article",article);

        return "article";
    }

    @GetMapping("/modify-article")
    public String modifyArticle(@RequestParam(required = true) Long id, Model model){
        Article article = articleService.findById(id);
        model.addAttribute("article" ,article);
        return "modify";
    }

    @PutMapping("/modify-article")
    @ResponseBody
    public ResponseEntity<Article> updateArticle(@PathVariable Long id,
                                                 @RequestBody Article articleReq){
        //ResponseEntity<Article> result =null;
        articleReq.setId(id);
        Article article = articleService.modify(articleReq);

        //result = new ResponseEntity<Article>(articleReq, HttpStatus.OK);
        return ResponseEntity.ok().body(article);

    }

    @DeleteMapping("/delete-article/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        articleService.remove(id);

        return ResponseEntity.ok().build();
    }
}
