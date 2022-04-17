package com.youxin.service;

import com.youxin.pojo.Article;
import com.youxin.utils.DataMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ArticleService {

    public DataMap saveArticle(Article article);

    List<Article> findAllArticles();

    Article selArticleById(Integer id);
}
