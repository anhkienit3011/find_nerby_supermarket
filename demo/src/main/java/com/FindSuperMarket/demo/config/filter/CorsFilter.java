package com.FindSuperMarket.demo.config.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.core.config.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(3)
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        chain.doFilter(request, response);
    }
}
