package com.youxin.mapper;

import com.youxin.pojo.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author youxin
 * @program youxinblog
 * @description 登陆mapper
 * @date 2022-02-08 21:45
 */
@Mapper
public interface LoginMapper {

    /**
     * @author youxin
     * @date 2022-02-08 21:49
     * @param userName
     * @return com.youxin.pojo.User
     * @throws
     * @since
     */
    //通过用户名查找是否存在该用户
    public User findUserByName(String userName);
}
