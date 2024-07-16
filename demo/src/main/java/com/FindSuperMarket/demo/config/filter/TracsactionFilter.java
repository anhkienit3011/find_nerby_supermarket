package com.FindSuperMarket.demo.config.filter;

import com.FindSuperMarket.demo.exception.GlobalExceptionHandler;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
@Order(1)

public class TracsactionFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Initializing filter :{}", this);
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        logger.info("Starting transaction for req : {}",req.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
        logger.info("Committing Transaction for req :{}", req.getRequestURI());
    }

    @Override
    public void destroy() {
        logger.warn("Destructing filter :{}", this);
    }
}
