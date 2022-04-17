package com.youxin.controller;

import com.youxin.constant.CodeType;
import com.youxin.service.impl.CategoryServiceImpl;
import com.youxin.utils.DataMap;
import com.youxin.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author youxin
 * @program youxinblog
 * @description 文章类别名控制器
 * @date 2022-02-10 00:21
 */
@RestController
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryService;

    /**
     * 获得所有的分类
     * @return
     */
    @GetMapping(value = "/findCategoriesName", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String findCategoriesName(){
        try {
            DataMap data = categoryService.findCategoriesName();
            return JsonResult.build(data).toJSON();
        } catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
    }

}
