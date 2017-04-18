package com.kaishengit.service;

import com.google.common.collect.Maps;
import com.kaishengit.mapper.RoleMapper;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.mapper.UserlogMapper;
import com.kaishengit.pojo.User;
import com.kaishengit.pojo.Userlog;
import com.kaishengit.util.ShiroUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;


import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

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

    public void saveUserLogin(String ip) {
        Userlog userlog = new Userlog();
        userlog.setLoginip(ip);
        userlog.setLogintime(DateTime.now().toString("yyyy-MM-dd HH:mm"));
        userlog.setUserid(ShiroUtil.getCurrentUserID());

        userlogMapper.save(userlog);
    }

    ;

    /**
     * 修改用户密码
     *
     * @param password
     */
    public void changePassword(String password) {
        User user = ShiroUtil.getCurrentUser();
        user.setPassword(DigestUtils.md5Hex(password));

        userMapper.updateUser(user);
    }

    /**
     * 获取当前登录用户的登录日志
     *
     * @param start
     * @param length
     * @return
     */
    public List<Userlog> findCurrentUserLog(String start, String length) {
        Map<String, Object> param = Maps.newHashMap();
        param.put("userId", ShiroUtil.getCurrentUserID());
        param.put("start", start);
        param.put("length", length);
        return userlogMapper.findByParam(param);
    }

    /**
     * 获取当前登录用户的日志数量
     *
     * @return
     */
    public Long findCurrentUserLogCount() {
        Map<String, Object> param = Maps.newHashMap();
        param.put("userId", ShiroUtil.getCurrentUserID());
        return userlogMapper.countByParam(param);
    }

}
