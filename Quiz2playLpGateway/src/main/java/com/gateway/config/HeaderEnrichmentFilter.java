package com.gateway.config;

import java.io.IOException;
import java.util.Enumeration;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class HeaderEnrichmentFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
		String jinnyCid = httpServletRequest.getHeader("x-jinny-cid");
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-jinny-cid", jinnyCid);
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		chain.doFilter(request, response);
	}
}
