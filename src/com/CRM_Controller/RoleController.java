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
import javax.servlet.http.HttpSession;

import com.CRM.CONST.UrlConst;
import com.CRM_Entity.Role;
import com.CRM_Entity.User;
import com.Connection.getConnection;
import com.DAO.RoleDAO;

import sun.dc.pr.PRError;

@WebServlet(urlPatterns = { UrlConst.ROLE_TABLE, UrlConst.ROLE_ADD, UrlConst.ROLE_DELETE, UrlConst.ROLE_EDIT })
public class RoleController extends HttpServlet {
	private RoleDAO roleDAO = null;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		roleDAO = new RoleDAO();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Role> roles = roleDAO.getRolesFromDB();
		req.setAttribute("roleList", roles);
		chuyenTrang(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		functionCategory(req, resp);
	}

	public void chuyenTrang(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String duongDan = req.getServletPath();
		System.out.println(duongDan);

		switch (duongDan) {
		case UrlConst.ROLE_ADD:
			req.getRequestDispatcher("/views/role/RoleAdd.jsp").forward(req, resp);
			break;
		case UrlConst.ROLE_DELETE:
			DeleteByID(req, resp);
			resp.sendRedirect(req.getContextPath() + UrlConst.ROLE_TABLE);
			break;
		case UrlConst.ROLE_EDIT:
			displayRoleToEdit(req, resp);
			req.getRequestDispatcher("/views/role/RoleEdit.jsp").forward(req, resp);
			break;
		default:
			req.getRequestDispatcher("/views/role/RoleTable.jsp").forward(req, resp);
			break;

		}
	}
	
	public void functionCategory (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String duongDan = req.getServletPath();
		System.out.println(duongDan);

		switch (duongDan) {
		case UrlConst.ROLE_ADD:
			sendDataToDB(req, resp);
			break;
		case UrlConst.ROLE_DELETE:
			
			break;
		case UrlConst.ROLE_EDIT:
			editUser(req, resp);
			break;
		

		}
	}
	

	// Gửi dữ liệu lên DB
	public void sendDataToDB(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = roleDAO.addData(getUserInput(req, resp));// Dữ liệu dược lấy ở đây
		checkSendData(req, resp, result);
	}

	// Lấy dữ liệu từ form
	public Role getUserInput(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String description = req.getParameter("description");

		// kiểm tra form người dùng nhập có bị rỗng không
		if (validataUserInput(name) == false) {
			req.setAttribute("errorMessage", "Form is empty");
			req.getRequestDispatcher("/views/role/RoleAdd.jsp").forward(req, resp);
			return null;
		}

		if (validataUserInput(description) == false) {
			req.getRequestDispatcher("/views/role/RoleAdd.jsp").forward(req, resp);
			return null;
		}
		Role role = new Role(name, description);
		return role;
	}

	// Hàm kiểm tra rỗng
	public boolean validataUserInput(String validataHere) throws ServletException, IOException {

		if (validataHere.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	// Hàm kiểm tra coi gửi dữ liệu có thành công không
	public void checkSendData(HttpServletRequest req, HttpServletResponse resp, int checkHere)
			throws IOException, ServletException {
		// dữ liệu cần kiểm tra ở đây
		if (checkHere > 0) {
			resp.sendRedirect(req.getContextPath() + UrlConst.ROLE_TABLE);

		} else {
			req.setAttribute("errorMessage02", "Add item false");
			req.getRequestDispatcher("/views/role/RoleAdd.jsp").forward(req, resp);
			return;
		}
	}

	// Xóa role theo id
	public void DeleteByID(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		roleDAO.DeleteByID(id);

	}
	
	// edit user 
	public void editUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int roleID = Integer.parseInt(req.getParameter("id"));
		roleDAO.editRole(roleEditForm(req, resp), roleID);//Gửi dữ liệu từ form roleEdit sửa lên DB
		resp.sendRedirect(req.getContextPath() + UrlConst.ROLE_TABLE);
	}
	
	//Lấy dữ liệu từ form 
	public Role roleEditForm(HttpServletRequest req, HttpServletResponse resp) {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		Role role = new Role(name,description);
		return role;
	}
	
	
	// Lấy Role theo id dùng để edit
		public void displayRoleToEdit(HttpServletRequest req, HttpServletResponse resp) {
			int id = Integer.parseInt(req.getParameter("id"));
			System.out.println("get id succes: "+id);
			Role role = roleDAO.displayRole(id);
			req.setAttribute("roleToEdit", role);
		}

}
