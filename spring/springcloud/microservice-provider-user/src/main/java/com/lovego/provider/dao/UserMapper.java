package com.lovego.provider.dao;

import com.common.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2017/5/21 0021.
 */
@Mapper
public interface  UserMapper {
    User findUserById(Integer id);
}
