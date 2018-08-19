package com.infytel.app.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class CORSFilter extends OncePerRequestFilter {
    @Override
    public void destroy() {
        System.out.println("destroy filter. release our resources here if any");
    }
    
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		HttpServletResponse httpServletResponse=(HttpServletResponse)response;
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-type");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        filterChain.doFilter(request, response);    
		
	}

}
