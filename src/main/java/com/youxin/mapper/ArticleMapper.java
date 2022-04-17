package com.youxin.mapper;

import com.youxin.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    public int saveArticle(Article article);

    public List<Article> findAllArticles();

    Article selArticleById(Integer id);

}
