package com.youxin.mapper;

import com.youxin.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    public List<String> findCategoriesName();
}
