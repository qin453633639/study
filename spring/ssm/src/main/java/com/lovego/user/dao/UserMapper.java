package com.lovego.user.dao;

import java.util.List;
import com.lovego.user.po.User;

public interface UserMapper {
	int add(User user);
	int delete(long id);
	int edit(User user);
	List<User> list(long begin,long end);
	
	long size();
}
