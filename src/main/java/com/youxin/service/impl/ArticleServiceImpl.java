package com.youxin.service.impl;

import com.youxin.mapper.ArticleMapper;
import com.youxin.pojo.Article;
import com.youxin.service.ArticleService;
import com.youxin.utils.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author youxin
 * @program youxinblog
 * @description 文章业务层实现类
 * @date 2022-02-10 23:12
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;


    @Override
    public DataMap saveArticle(Article article) {
        Map<String, Object> dataMap = new HashMap<>(4);
        int i = articleMapper.saveArticle(article);
        //如果存入成功就返回正确状态码，失败就返回错误状态码
        if (i > 0) {
            return DataMap.success().setData(dataMap);
        }else {
            return DataMap.fail().setData(dataMap);
        }
    }

    @Override
    public List<Article> findAllArticles() {
        return articleMapper.findAllArticles();
    }

    @Override
    public Article selArticleById(Integer id) {
        return articleMapper.selArticleById(id);
    }
}
