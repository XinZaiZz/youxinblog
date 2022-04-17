package com.youxin.service.impl;

import com.youxin.mapper.LoginMapper;
import com.youxin.pojo.User;
import com.youxin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author youxin
 * @program youxinblog
 * @description 登陆业务实现类
 * @date 2022-02-08 22:00
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public User FindUserByName(String userName) {
        return loginMapper.findUserByName(userName);
    }
}
