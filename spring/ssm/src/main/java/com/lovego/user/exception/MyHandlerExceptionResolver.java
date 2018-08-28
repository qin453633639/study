package com.lovego.user.exception;

import com.lovego.user.util.ResponseUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by qinwei on 2018/8/27.
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String message  = ex.getMessage();
        if(ex instanceof UserException && StringUtils.isNoneBlank(message)){
            out.write(ResponseUtil.writeResult(500, message+1));
        }else{
            out.write(ResponseUtil.writeResult(500, "服务器错误1111"));
        }
        return null;
    }
}
