package com.kaishengit.util;

import com.kaishengit.pojo.User;
import org.apache.shiro.SecurityUtils;

/**
 * Created by acer on 2017/4/18.
 */
public class ShiroUtil {
    public static User getCurrentUser() {
                return (User) SecurityUtils.getSubject().getPrincipal();
            }

                public static Integer getCurrentUserID() {
                return getCurrentUser().getId();
            }

                public static String getCurrentUserName() {
                return getCurrentUser().getUsername();
            }
}
