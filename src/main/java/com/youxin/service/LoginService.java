package com.youxin.service;

import com.youxin.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author youxin
 * @program youxinblog
 * @description 登陆业务类
 * @date 2022-02-08 21:57
 */

public interface LoginService {

    public User FindUserByName(String userName);
}
