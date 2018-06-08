package com.lovego.user.filter;

import javax.servlet.*;
import java.io.IOException;

public class OneFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("OneFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("OneFilter doFilter");
        chain.doFilter(request, response);
}

    @Override
    public void destroy() {
        System.out.println("OneFilter destroy");
    }
}
