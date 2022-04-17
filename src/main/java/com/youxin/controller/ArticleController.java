package com.youxin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youxin.pojo.Article;
import com.youxin.pojo.User;
import com.youxin.service.ArticleService;
import com.youxin.utils.BuildArticleTabloidUtil;
import com.youxin.utils.DataMap;
import com.youxin.utils.DateUtil;
import com.youxin.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author youxin
 * @program youxinblog
 * @description 文章controller
 * @date 2022-02-09 21:31
 */
@Controller
public class ArticleController {

    @Autowired
    DateUtil dateUtil;

    @Autowired
    ArticleService articleService;

    @RequestMapping("/article/toArticleWritePage")
    public String toArticleWritePage() {
        return "article/article";
    }

    @PostMapping(value = "/publishArticle")
    @ResponseBody
    public String publishArticle(HttpServletRequest request, Article article) {
        //获得文章html代码并生成摘要
        BuildArticleTabloidUtil buildArticleTabloidUtil = new BuildArticleTabloidUtil();
        String articleHtmlContent = buildArticleTabloidUtil.buildArticleTabloid(request.getParameter("articleHtmlContent"));
        //设置文章摘要
        article.setArticleTabloid(articleHtmlContent + "...");

        //获取当前用户
        User user = (User) request.getSession().getAttribute("user");
        //将当前用户id设置为文章归属用户Id
        article.setUserID(user.getUserID());
        article.setArticleTitle(request.getParameter("articleTitle"));
        article.setArticleType(request.getParameter("articleType"));
        article.setArticleCategories(request.getParameter("articleCategories"));
        article.setArticleHtmlContent(request.getParameter("articleHtmlContent"));
        article.setArticleContent(request.getParameter("articleContent"));
        article.setReleaseDate(dateUtil.getSystemDateToString());
        DataMap data = articleService.saveArticle(article);
        //返回状态状态标识
        return JsonResult.build(data).toJSON();

    }

    @ResponseBody
    @GetMapping(value = "/findAllArticles")
    public String findAllArticles() throws JsonProcessingException {
        //将List转为json对象
        //创建jackson的核心对象:ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        List<Article> articles;
        articles = articleService.findAllArticles();
        //调用objectMapper对象的writeValueAsString方法将对象转化为json对象
        String result = objectMapper.writeValueAsString(articles);
        return result;
    }

    @GetMapping("/article/show/{id}")
    //通过 @PathVariable 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“)
    public String toShowArticle(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {//其中@PathVariable("id")必须与请求中的id相同
        Article article = articleService.selArticleById(id);
        model.addAttribute("article",article);
        //获取当前用户
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("user",user);
        return "article/show";
    }
}
