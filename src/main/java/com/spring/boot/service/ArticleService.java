package com.spring.boot.service;

import com.spring.boot.model.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticles();
    Article findById(Long id);
    Article modify(Article article);
    Article save(Article article);
    void remove(Long id);
}
