package com.youxin.mapper;

import com.youxin.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AboutMeMapper {

    Article selArticleById(Integer id);
}
