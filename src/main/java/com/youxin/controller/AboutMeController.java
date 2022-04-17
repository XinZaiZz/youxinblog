package com.youxin.controller;

import com.youxin.pojo.Article;
import com.youxin.pojo.User;
import com.youxin.service.AboutMeService;
import com.youxin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * @author youxin
 * @program youxinblog
 * @description
 * @date 2022-02-12 20:53
 */
@Controller
public class AboutMeController {

    @Autowired
    AboutMeService aboutMeService;

    @GetMapping("/aboutme/show/{id}")
    //通过 @PathVariable 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“)
    public String toShowArticle(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {//其中@PathVariable("id")必须与请求中的id相同
        Article article = aboutMeService.selArticleById(id);
        model.addAttribute("article",article);
        //获取当前用户
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("user",user);
        return "article/show";
    }
}
