package com.FindSuperMarket.demo.config.filter;



import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Order(3)
public class ResponseFormattingFilter implements Filter {

    private final ObjectMapper objectMapper;

    public ResponseFormattingFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) response);

        chain.doFilter(request, responseWrapper);

        byte[] responseArray = responseWrapper.getContentAsByteArray();
        String responseBody = new String(responseArray, responseWrapper.getCharacterEncoding());

        Map<String, Object> formattedResponse = new HashMap<>();
        formattedResponse.put("status", "success");
        formattedResponse.put("data", objectMapper.readValue(responseBody, Object.class));

        byte[] formattedResponseArray = objectMapper.writeValueAsBytes(formattedResponse);
        response.getOutputStream().write(formattedResponseArray);
        response.setContentLength(formattedResponseArray.length);
        response.setContentType("application/json");
    }
}
