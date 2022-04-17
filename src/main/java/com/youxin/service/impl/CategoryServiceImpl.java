package com.youxin.service.impl;

import com.youxin.mapper.CategoryMapper;
import com.youxin.service.CategoryService;
import com.youxin.utils.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author youxin
 * @program youxinblog
 * @description
 * @date 2022-02-10 00:38
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;


    @Override
    public DataMap findCategoriesName() {
        List<String> categoryNames = categoryMapper.findCategoriesName();
        return DataMap.success().setData(categoryNames);
    }

}
