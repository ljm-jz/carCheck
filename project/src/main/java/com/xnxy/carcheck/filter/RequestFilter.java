package com.xnxy.carcheck.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

public class RequestFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest req,
			HttpServletResponse resp, FilterChain chain)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String uri = req.getRequestURI();
		if(!(uri.endsWith(".js")||uri.endsWith(".css")||uri.endsWith(".jpg")||uri.endsWith("login1.html")||uri.endsWith("login.action"))&&session.getAttribute("manager")==null)
			resp.sendRedirect("login1.html");
		else
			chain.doFilter(req, resp);
	}

}
