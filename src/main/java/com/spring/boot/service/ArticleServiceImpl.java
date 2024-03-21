package com.spring.boot.service;

import com.spring.boot.dao.ArticleDAO;
import com.spring.boot.model.Article;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleDAO articleDAO;
    @Override
    public List<Article> getAllArticles() {
        return articleDAO.findAll();
    }

    @Override
    public Article findById(Long id) {
        return articleDAO.findById(id).orElseThrow(()->new IllegalArgumentException("not found: "+id));
    }

    @Override
    @Transactional
    public Article modify(Article article) {
        Article get_article = findById(article.getId());
        get_article.update(article.getTitle(),article.getContent());
        return get_article;
    }

    @Override
    public Article save(Article article) {
        return articleDAO.save(article);
    }


    @Override
    public void remove(Long id) {
        articleDAO.deleteById(id);
    }
}
