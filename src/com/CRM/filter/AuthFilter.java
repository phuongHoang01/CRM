package com.CRM.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.CRM_Entity.User;
import com.DAO.LoginDAO;

public class AuthFilter implements Filter {
	LoginDAO loginDAO = null;
		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			
			HttpSession session  = req.getSession();
			
			String duongDan = req.getServletPath();
			if(duongDan.equals("/Login")) {
				chain.doFilter(request, response); 
				return;
			}
			
			User user = (User)session.getAttribute("User_login");
			if(session.getAttribute("User_login")==null) {
				resp.sendRedirect(req.getContextPath()+"/Login");
				return;
			}
			
			
			if(duongDan.startsWith("/admin")) {
				
				if(user.getDescription().equals("Quản trị hệ thống")){
					chain.doFilter(request, response);
					return;
				}
				else {
				resp.sendRedirect(req.getContextPath()+"/BlankError/error");
				return;
				}
				
			}
			else if(duongDan.startsWith("/manager")) {
				System.out.println("u run here right ?");
					if(user.getDescription().equals("Quản trị hệ thống") || user.getDescription().equals("Quản lý")) {
						chain.doFilter(request, response);
						return;
					}
					
					else {
						resp.sendRedirect(req.getContextPath()+"/BlankError/error");
						return;
					}
			}
			
			
			
			chain.doFilter(request, response); 
			
			
			
			
		}
}
