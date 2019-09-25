package com.CRM_Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CRM.CONST.UrlConst;
import com.CRM_Entity.Job;
import com.CRM_Entity.Role;
import com.Connection.getConnection;
import com.DAO.JobDAO;
import com.sun.xml.internal.bind.v2.model.core.ID;

@WebServlet(urlPatterns = { UrlConst.GROUP_ADD, UrlConst.GROUP_DELETE, UrlConst.GROUP_DETAILS, UrlConst.GROUP_TABLE,UrlConst.GROUP_EDIT })
public class GroupWorkController extends HttpServlet {
	private JobDAO jobDAO = null;
	private List<Job> jobs = null;
	private SimpleDateFormat format = null;
	

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		jobDAO = new JobDAO();
		jobs = new ArrayList<Job>();
		format = new SimpleDateFormat("yyyy-MM-dd");
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		jobs = jobDAO.getDataFromDB();
		req.setAttribute("jobs", jobs);
		
		chuyenTrang(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		funtionCategory(req, resp);

	}

	public void chuyenTrang(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String duongDan = req.getServletPath();
		System.out.println(duongDan);

		switch (duongDan) {
		case UrlConst.GROUP_ADD:
			req.getRequestDispatcher("/views/group/GroupWorkAdd.jsp").forward(req, resp);
			break;
		case UrlConst.GROUP_EDIT:
			displayRoleToEdit(req, resp);
			req.getRequestDispatcher("/views/group/GroupWorkEdit.jsp").forward(req, resp);
			break;
		case UrlConst.GROUP_DETAILS:
			req.getRequestDispatcher("/views/group/GroupWorkDetails.jsp").forward(req, resp);
			break;
		case UrlConst.GROUP_DELETE:
			DeleteByID(req, resp);
			resp.sendRedirect(req.getContextPath() + UrlConst.GROUP_TABLE);
			break;
		default:
			req.getRequestDispatcher("/views/group/GroupWorkTable.jsp").forward(req, resp);
			break;

		}
	}
	
	public void funtionCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String duongDan = req.getServletPath();
		System.out.println(duongDan);

		switch (duongDan) {
		case UrlConst.GROUP_ADD:
			sendJobToDB(req, resp);
			break;
		case UrlConst.GROUP_EDIT:
			System.out.println("are u going here right");
			editJob(req, resp);
			break;
		case UrlConst.GROUP_DETAILS:
			break;
		case UrlConst.GROUP_DELETE:
			
			break;
		

		}
	}

	// Gửi thông tin người dùng điền từ form lên database
	public void sendJobToDB(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		jobDAO.sendDataToDB(jobForm (req, resp));//thông tin người dùng ở đây
		resp.sendRedirect(req.getContextPath() + UrlConst.GROUP_TABLE);

	}

	// Lấy dữ liệu từ form
	public Job jobForm (HttpServletRequest req, HttpServletResponse resp) {
		String tenCongViec = req.getParameter("tenCongViec");
		Date ngayBatDau = null;
		Date ngayKetThuc = null;
		try {
			ngayBatDau = format.parse((req.getParameter("ngayBatDau")));
			System.out.println(ngayBatDau);
			ngayKetThuc = format.parse((req.getParameter("ngayKetThuc")));
			System.out.println(ngayKetThuc);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date ngayBatDausql = new java.sql.Date(ngayBatDau.getTime());
		java.sql.Date ngayKetThucsql = new java.sql.Date(ngayKetThuc.getTime());
		Job job = new Job(tenCongViec, ngayBatDausql, ngayKetThucsql);
		return job;
	}
	
	
	// Xóa theo ID
	public void DeleteByID(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		jobDAO.DeleteByID(id);

	}
	
	//Hàm update job
	public void editJob(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int jobID = Integer.parseInt(req.getParameter("id"));
		System.out.println(jobID);
		jobDAO.editJob(jobForm(req, resp), jobID);//Lấy dữ liệu từ form xong gửi lên DB
		resp.sendRedirect(req.getContextPath() + UrlConst.GROUP_TABLE);
		
	}
	
	//Hiển thi job ra form để sửa 
	public void displayRoleToEdit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int JobID = Integer.parseInt(req.getParameter("id"));
		Job job = jobDAO.getJobFromDbToEdit(JobID);//Lấy job từ db
		req.setAttribute("jobToEdit", job);
		
	}
	

}
