package com.kaishengit.mapper;

import com.kaishengit.pojo.User;


/**
 * Created by acer on 2017/4/14.
 */
public interface UserMapper {
     User findByName(String username);

     void updateUser(User user);
}
