package com.kaishengit.mapper;

import com.kaishengit.pojo.Userlog;

import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2017/4/14.
 */
public interface UserlogMapper {
    void save(Userlog userlog);
    List<Userlog> findByParam(Map<String, Object> param);

    Long countByParam(Map<String, Object> param);
}
