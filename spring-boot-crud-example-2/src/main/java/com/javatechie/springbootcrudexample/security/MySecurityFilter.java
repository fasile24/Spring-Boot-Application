package com.javatechie.springbootcrudexample.security;

import jakarta.servlet.*;

import java.io.IOException;

public class MySecurityFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        System.out.println("Before");
        filterChain.doFilter(request,response);
        System.out.println("After");

    }
}
