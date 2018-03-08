package com.lovego.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alibaba.fastjson.JSONObject;
import com.lovego.user.exception.UserException;
import com.lovego.user.util.ResponseUtil;

public class BaseConroller {
	
	@ExceptionHandler
	public void exception(HttpServletRequest request,HttpServletResponse response,Exception e) throws IOException{
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String message  = e.getMessage();
		if(e instanceof UserException && StringUtils.isNoneBlank(message)){
			out.write(ResponseUtil.writeResult(500, message));
		}else{
			out.write(ResponseUtil.writeResult(500, "服务器错误"));
		}
		 
	}
}
