package com.lovego.user.service;

import java.util.Date;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lovego.user.dao.UserMapper;
import com.lovego.user.exception.UserException;
import com.lovego.user.po.User;

public class UserService {
	@Autowired  
	private SqlSessionTemplate  sqlSession; 
	public List<User> list(long begin,long end){
		
		return sqlSession.getMapper(UserMapper.class).list(begin,end);
		 
	}
	
	public void add(User user){
		if(user == null){
			throw new UserException("用户为空！"); 
		}
		 
		int count = sqlSession.getMapper(UserMapper.class).add(user);
		if(count == 0){
			throw new UserException("新增用户失败！"); 
		}
	}
	
	public void delete(long userId){
		if(userId <= 0){
			throw new UserException("Id不能为零或小于零！");
			
		}
		int count = this.sqlSession.getMapper(UserMapper.class).delete(userId);
		if(count == 0){
			throw new UserException("用户不存在！");
		}
	}
	public void edit(User user){
		if(user == null){
			throw new UserException("用户为空！"); 
		}
		int count = sqlSession.getMapper(UserMapper.class).edit(user);
		if(count == 0){
			throw new UserException("修改用户失败！"); 
		}
		
	}
	
	 
	public long size(){
		return sqlSession.getMapper(UserMapper.class).size();
	}
	
	 
}
