package com.lovego.mybatis.mapper;


import com.lovego.mybatis.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2017/5/21 0021.
 */

@Mapper
public interface UserMapper {
    User findUserById(int id);
}
