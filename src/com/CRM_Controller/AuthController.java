package com.CRM_Controller;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.CRM.CONST.UrlConst;
import com.CRM_Entity.User;
import com.DAO.LoginDAO;
import com.DAO.UserDAO;
import com.mysql.cj.Session;

@WebServlet(urlPatterns = {UrlConst.AUTH_LOGIN,UrlConst.AUTH_LOGOUT})
public class AuthController extends HttpServlet {
	private UserDAO userDAO = null;
	private List<User> users = null;
	private LoginDAO loginDAO = null;
	private HttpSession seasion = null;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		userDAO = new UserDAO();
		users = userDAO.getDataFormDB();
		loginDAO = new LoginDAO();
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		chuyenTrang(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		checkLogin(req, resp);
		
	}
	
	// Kiểm tra đăng nhập
	public void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String email = req.getParameter("email");
		String password =req.getParameter("password");
		System.out.println(UrlConst.AUTH_LOGIN);
		//Lấy user từ DB có email và password tương úng
		User user = loginDAO.findByEmail(email,password);
		
		
		if(user != null) {
			System.out.println("hello: "+user.getDescription());
			resp.sendRedirect(req.getContextPath()+"/Home");
			
		}
		else {
			req.setAttribute("message01", "Sai Mật khẩu hoặc email");
			req.getRequestDispatcher("/views/login/login.jsp").forward(req, resp);
			return;
			
		}
		HttpSession seasion = req.getSession();
		seasion.setAttribute("User_login", user);
		
		

	}
	//Chuyển trang 
	public void chuyenTrang(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String duongDan = req.getServletPath();
		System.out.println(duongDan);
		
		switch (duongDan) {
		case UrlConst.AUTH_LOGIN:
			req.getRequestDispatcher("/views/login/login.jsp").forward(req, resp);
			break;
		case UrlConst.AUTH_LOGOUT:
				HttpSession session = req.getSession();
				session.removeAttribute("User_login");
				resp.sendRedirect(req.getContextPath()+UrlConst.AUTH_LOGIN);
				break;
			
		}
	}
	
	
	
	
	
}
