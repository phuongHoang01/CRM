package com.CRM_Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CRM.CONST.UrlConst;
import com.CRM_Entity.User;
import com.DAO.UserDAO;
@WebServlet(urlPatterns = {UrlConst.HOME})
public class HomeController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
