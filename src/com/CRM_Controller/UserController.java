package com.CRM_Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

import javax.management.relation.RoleList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import com.CRM.CONST.UrlConst;
import com.CRM_Entity.Role;
import com.CRM_Entity.User;
import com.Connection.getConnection;
import com.DAO.RoleDAO;
import com.DAO.UserDAO;
import com.sun.xml.internal.bind.v2.model.core.ID;

import sun.dc.pr.PRError;

@WebServlet(urlPatterns = { UrlConst.USER_ADD, UrlConst.USER_DELETE, UrlConst.USER_DETAIL, UrlConst.USER_EDIT,UrlConst.USER_TABLE })
public class UserController extends HttpServlet {
	private UserDAO userDAO = null;
	private RoleDAO roleDAO = null;
	private UrlConst urlConst = null;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		userDAO = new UserDAO();
		roleDAO = new RoleDAO();
		urlConst = new UrlConst();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> users = userDAO.getDataFormDB();
		List<Role> roles = roleDAO.getRolesFromDB();
		req.setAttribute("roles", roles);
		req.setAttribute("users", users);
		
		chuyenTrang(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("call 2 time right ?");
		functionCategory(req, resp);
	}
	
	public void functionCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String duongDan = req.getServletPath();
		System.out.println("go here 0: "+duongDan);
		
		switch (duongDan) {
		case UrlConst.USER_ADD:
			System.out.println("go here twice right ?");
			sendDataToDB(req, resp);
			break;
		case UrlConst.USER_DETAIL:
			
			break;
		case UrlConst.USER_EDIT:
			System.out.println("i came");
			editUser(req, resp);
			break;
		case UrlConst.USER_DELETE:
			break;
		
		}
	}

	public void chuyenTrang(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String duongDan = req.getServletPath();
		System.out.println(duongDan);

		switch (duongDan) {
		case UrlConst.USER_ADD:
			req.getRequestDispatcher("/views/user/UserAdd.jsp").forward(req, resp);
			break;
		case UrlConst.USER_DETAIL:
			req.getRequestDispatcher("/views/user/UserDetails.jsp").forward(req, resp);
			break;
		case UrlConst.USER_EDIT:
			displayUsers(req, resp);
			req.getRequestDispatcher("/views/user/UserEdit.jsp").forward(req, resp);
			
			break;
		case UrlConst.USER_DELETE:
			DeleteByID(req, resp);
			System.out.println(Integer.parseInt(req.getParameter("id")));
			resp.sendRedirect(req.getContextPath() + UrlConst.USER_TABLE);
			break;

		default:
			req.getRequestDispatcher("/views/user/UserTable.jsp").forward(req, resp);
			break;

		}
	}

	// Lấy user theo id dùng để edit
	public void displayUsers(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		User user = userDAO.displayUser(id);
		System.out.println(user);
		req.setAttribute("user", user);
	}

	// Gửi dữ liệu lên DB
	public void sendDataToDB(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int result = userDAO.addUser(getUserInput(req, resp));// Lây dữ liệu từ form xong ném lên DB
		checkSendData(req, resp, result);// Kiểm tra dữ liệu có đến được DB hay không
		
	}
	
	
	// Lấy data từ form xong bỏ vào thg user
	public User getUserInput(HttpServletRequest req, HttpServletResponse resp) {
		String fullName = req.getParameter("fullName");
		String email = req.getParameter("example-email");
		String password = req.getParameter("password");
		String avatar = req.getParameter("avatar");
		int selectRole = Integer.parseInt(req.getParameter("role"));
		User user = new User(email, password, fullName, avatar, selectRole);
		return user;
	}

	// Hàm kiểm tra dữ liệu gửi đi
	public void checkSendData(HttpServletRequest req, HttpServletResponse resp, int checkHere) throws IOException {
		if (checkHere != -1) {
			resp.sendRedirect(req.getContextPath() + UrlConst.USER_TABLE);
			
		} else {
			System.out.println("fail");
		}
	}
	
	
	// sửa dữ liệu người dùng
	public void editUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int userID = Integer.parseInt(req.getParameter("id"));
		userDAO.editUser(UserEditForm(req, resp), userID);//Gửi dữ liệu từ form người dùng sửa lên DB
		resp.sendRedirect(req.getContextPath() + UrlConst.USER_TABLE);
	}
	
	//form User edit 
	public User UserEditForm(HttpServletRequest req, HttpServletResponse resp) {
		String fullName = req.getParameter("fullName");
		String email = req.getParameter("email");
		String avatar = req.getParameter("avatar");
		int selectRole = Integer.parseInt(req.getParameter("role"));
		User user = new User(email,fullName, avatar, selectRole);
		return user;
	}

	public void DeleteByID(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		userDAO.DeleteByID(id);

	}
}
