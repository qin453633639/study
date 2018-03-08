package com.lovego.user.po;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;

/**
 * <p>用户实体类</p>
 * @dateTime 2017年4月19日 下午2:57:10 
 * @author 秦巍  qinwei@lovego.com 
 * @version 1.00
 */
public class User {
	private int id;
	
	@NotEmpty(message="姓名不能为空！")
	private String name;
	private int age;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date brith;
	private int  sex;
	private String addr;
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBrith() {
		return brith;
	}
	public void setBrith(Date brith) {
		this.brith = brith;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public static  User  fromJson(JSONObject json) throws ParseException{
		SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
		User u = new User();
		u.setId(json.containsKey("id")?json.getIntValue("id"):-1);
		u.setName(json.containsKey("name")?json.getString("name"):"");
		u.setAge(json.containsKey("age")?json.getIntValue("age"):0);
		u.setBrith(json.containsKey("brith")?format.parse(json.getString("brith")):new Date());
		u.setSex(json.containsKey("sex")?json.getIntValue("sex"):1);
		u.setAddr(json.containsKey("addr")?json.getString("addr"):"");
		return u;
	}
	
	public static JSONObject toJson(User user){
		SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
		JSONObject json = new JSONObject();
		json.put("id", user.getId());
		json.put("name", user.getName());
		json.put("age", user.getAge());
		json.put("brith", user.getBrith()== null?"":format.format(user.getBrith()));
		json.put("sex", user.getSex());
		json.put("addr", user.getAddr());
		return json;
	}
	
	public static JSONArray toJsonArray(List<User> users){
		JSONArray arr = new JSONArray();
		if(users == null || users.size() == 0){
			return arr;
		}
		for(User u :users){
			arr.add(toJson(u));
		}
		return arr;
	}
	
	 
}
