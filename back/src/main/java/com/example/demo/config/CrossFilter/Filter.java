package com.example.demo.config.CrossFilter;

import jakarta.servlet.*;

import java.io.IOException;

public interface Filter {
    void init(FilterConfig filterConfig) throws ServletException;

    void init(CORSFilter filterConfig) throws ServletException, ServletException;

    void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException;

    void destroy();
}
