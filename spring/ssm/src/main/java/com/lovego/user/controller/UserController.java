package com.lovego.user.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lovego.user.exception.UserException;
import com.lovego.user.po.User;
import com.lovego.user.service.UserService;
import com.lovego.user.util.ResponseUtil;
import com.lovego.user.util.ReturnCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * <p>用户控制层</p>
 * @dateTime 2017年4月19日 下午4:47:48 
 * @author 秦巍  qinwei@lovego.com 
 * @version 1.00
 */
@Controller
@RequestMapping ( "/user" )
@Api(value="用户控制器")
public class UserController extends BaseConroller{
	@Autowired  
    private UserService userService;
	
	@RequestMapping(value = "/delete", method={RequestMethod.GET} ,produces = "application/json;charset=utf-8")
	@ResponseBody
	public JSONObject delete(long id){
		throw new RuntimeException("aaa");
		/* userService.delete(id);
		 return ResponseUtil.writeResult(ReturnCode.C200);*/
		 
	}
	
	@RequestMapping(value = "/add", method={RequestMethod.POST},produces = "application/json;charset=utf-8") 
	@ResponseBody
	public JSONObject add( @Valid @ModelAttribute User user,BindingResult result) {
		if(result.hasErrors()){
			throw  new UserException(result.getAllErrors().get(0).getDefaultMessage());
	    }
		userService.add(user);
		 
		return ResponseUtil.writeResult(ReturnCode.C200);
	}
	
	@RequestMapping(value = "/list", method={RequestMethod.GET},produces = "application/json;charset=utf-8" )
	@ResponseBody
	public JSONObject list(HttpServletRequest request,HttpServletResponse response){
		int pageSize = StringUtils.isBlank(request.getParameter("pageSize"))?10:Integer.parseInt(request.getParameter("pageSize"));
		int page =  StringUtils.isBlank(request.getParameter("page"))?1:Integer.parseInt(request.getParameter("page"));
		long begin = (page-1)*pageSize;
		long end = page*pageSize -1;
		long totalCount = userService.size();
		long totalPages = (totalCount%pageSize)==0 ? totalCount/pageSize : (totalCount/pageSize)+1;
		List<User> users = userService.list(begin, end);
		JSONArray arr = User.toJsonArray(users);
		return ResponseUtil.writeResult(ReturnCode.C200, arr,page,totalPages,totalCount,pageSize);
	}
	
	@RequestMapping(value = "/edit", method={RequestMethod.POST} ,produces = "application/json;charset=utf-8")
	@ResponseBody
	public JSONObject edit(@Valid @ModelAttribute User user,BindingResult result) {
		if(result.hasErrors()){
			throw  new UserException(result.getAllErrors().get(0).getDefaultMessage());
	    }
		userService.edit(user);
		return ResponseUtil.writeResult(ReturnCode.C200);
	}
}
