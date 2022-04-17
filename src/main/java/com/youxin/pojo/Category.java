package com.youxin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author youxin
 * @program youxinblog
 * @description 文章类别实体类
 * @date 2022-02-10 00:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private Integer id;

    private String categoryName;
}
