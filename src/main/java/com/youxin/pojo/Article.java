package com.youxin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author youxin
 * @program youxinblog
 * @description 文章实体类
 * @date 2022-02-10 21:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private Integer id;

    private int userID;

    private String articleContent;

    private String articleHtmlContent;

    private String articleTabloid;

    private String articleTitle;

    private String articleType;

    private String releaseDate;

    private String articleCategories;
}
