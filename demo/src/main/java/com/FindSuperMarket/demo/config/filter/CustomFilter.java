package com.FindSuperMarket.demo.config.filter;


import jakarta.servlet.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import java.io.IOException;

@Component
@Order(1)  // Số thứ tự ưu tiên của filter
public class CustomFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Xử lý trước khi request đến controller
        System.out.println("Processing request: " + httpRequest.getRequestURI());

        // Chuyển request đến filter tiếp theo hoặc đến controller
        chain.doFilter(request, response);

        // Xử lý sau khi response được tạo
        System.out.println("Processing response: " + httpResponse.getStatus());
    }
}
