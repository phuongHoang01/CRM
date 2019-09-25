package com.CRM_Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CRM.CONST.UrlConst;
@WebServlet(urlPatterns = {UrlConst.BLANK_PAGE_BLANK,UrlConst.BLANK_PAGE_ERROR})

public class BlankErrPageController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		chuyenTrang(req, resp);
	}
	
	
	public void chuyenTrang(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String duongDan = req.getServletPath();
		System.out.println(duongDan);
		
		switch (duongDan) {
		case UrlConst.BLANK_PAGE_ERROR:
			req.getRequestDispatcher("/views/blankpage/Error.jsp").forward(req, resp);
			break;
		default:req.getRequestDispatcher("/views/blankpage/BlankPage.jsp").forward(req, resp);
			break;
		
		}
	}
}
