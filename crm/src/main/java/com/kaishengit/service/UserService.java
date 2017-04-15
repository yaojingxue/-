package com.kaishengit.service;

import com.kaishengit.mapper.RoleMapper;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.mapper.UserlogMapper;



import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by acer on 2017/4/14.
 */
@Named
public class UserService {
    @Inject
    private UserMapper userMapper;
    @Inject
    private UserlogMapper userlogMapper;
    @Inject
    private RoleMapper roleMapper;


}
