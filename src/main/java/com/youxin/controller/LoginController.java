package com.youxin.controller;

import com.youxin.pojo.Article;
import com.youxin.pojo.User;
import com.youxin.service.ArticleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author youxin
 * @program youxinblog
 * @description 登陆
 * @date 2022-02-05 22:55
 */

@Controller
public class LoginController {

    @Autowired
    ArticleService articleService;

    /**
     * @author youxin
     * @date 2022-02-08 22:32
     * @param session
     * @return java.lang.String
     * @throws 
     * @since 
     */
    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session) {
        session.setAttribute("msg","请先登陆！");
        return "login/login";
    }

    /**
     * @author youxin
     * @date 2022-02-08 22:32
     * @param username
     * @param password
     * @param rememberMe
     * @param model
     * @param session
     * @return java.lang.String
     * @throws 
     * @since 
     */
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, String password, String rememberMe, Model model, HttpSession session, HttpServletRequest request) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user",user);
            model.addAttribute("user",user);
            return "redirect:/toIndex";
        }catch (UnknownAccountException uae) {
            model.addAttribute("msg","用户名错误！");
            return "login/login";
        }catch (IncorrectCredentialsException ice) {
            model.addAttribute("msg","密码错误！");
            return "login/login";
        }
    }

    /**
     * @author youxin
     * @date 2022-02-09 `
     * @param
     * @return java.lang.String
     * @throws
     * @since
     */
    //登出
    @RequestMapping("/loginout")
    public String logout() {
        Subject currentSubject = SecurityUtils.getSubject();
        currentSubject.logout();
//        return "forward:/toLogin";
        return "redirect:/toIndex";
    }

    @GetMapping(value = {"/toIndex","/"})
    public String toIndex(HttpServletRequest request, Model model){
        //获取当前用户
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("user",user);

        //将List转为json对象
        List<Article> articles = new ArrayList<>();
        articles = articleService.findAllArticles();
//        JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(list));
        model.addAttribute("articles",articles);
        return "index";
    }



}
