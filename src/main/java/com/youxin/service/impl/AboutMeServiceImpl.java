package com.youxin.service.impl;

import com.youxin.mapper.AboutMeMapper;
import com.youxin.pojo.Article;
import com.youxin.service.AboutMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author youxin
 * @program youxinblog
 * @description
 * @date 2022-02-12 20:57
 */
@Service
public class AboutMeServiceImpl implements AboutMeService {

    @Autowired
    AboutMeMapper aboutMeMapper;

    @Override
    public Article selArticleById(Integer id) {
        return aboutMeMapper.selArticleById(id);
    }
}
