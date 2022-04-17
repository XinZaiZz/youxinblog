package com.youxin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

/**
 * @author youxin
 * @program youxinblog
 * @description 用户实体类
 * @date 2022-02-08 21:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer userID;

    private String userName;

    private String password;

    private String nickName;

    private Blob headImage;

    private String gender;

    private String perms;

}
