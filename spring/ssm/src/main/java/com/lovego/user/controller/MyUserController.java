package com.lovego.user.controller;

import com.lovego.user.po.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinwei on 2018/4/29.
 */
public class MyUserController  extends AbstractController{
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        User u = new User();
        u.setName("hello");

        return new ModelAndView("userlist","user",u);
    }
}
