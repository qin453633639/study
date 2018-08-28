package com.lovego.user.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lovego.user.exception.UserException;
import com.lovego.user.po.User;
import com.lovego.user.service.UserService;
import com.lovego.user.util.ResponseUtil;
import com.lovego.user.util.ReturnCode;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


/**
 *
 * <p>用户控制层</p>
 * @dateTime 2017年4月19日 下午4:47:48
 * @author 秦巍  qinwei@lovego.com
 * @version 1.00
 */
@Controller
@RequestMapping( "/card" )
@Api(value="用户控制器")
public class MyTestUserController {


    @RequestMapping(value = "/delete", method={RequestMethod.GET}  )
    @ResponseBody
    public JSONObject delete(){
        throw new RuntimeException("aaa");
		/* userService.delete(id);
		 return ResponseUtil.writeResult(ReturnCode.C200);*/

    }

    @RequestMapping(value = "/add", method={RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public JSONObject add(@Valid @ModelAttribute User user, BindingResult result) {
        if(result.hasErrors()){
            throw  new UserException(result.getAllErrors().get(0).getDefaultMessage());
        }


        return ResponseUtil.writeResult(ReturnCode.C200);
    }

}
