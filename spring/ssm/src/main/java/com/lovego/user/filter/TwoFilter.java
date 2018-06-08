package com.lovego.user.filter;

import javax.servlet.*;
import java.io.IOException;

public class TwoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Two init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Two doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("Two destroy");
    }
}