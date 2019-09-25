package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.CRM_Entity.Job;
import com.Connection.getConnection;
import com.sun.crypto.provider.RSACipher;

public class JobDAO {

	private final String SELECT_ALL_FROM = "SELECT * FROM crm_app.jobs;";
	private final String INSERT_INTO_ROLES = "INSERT INTO `crm_app`.`jobs` ( `name`, `start_date`, `end_date`) VALUES (?, ?, ?)";
	private final String DELECT_WHERE_ID = "Delete FROM crm_app.jobs WHERE id = ?";
	private final String SELECT_ALL_WHERE_ID = "SELECT * FROM crm_app.jobs WHERE id = ?";
	private final String UPDATE_WHERE_ID ="UPDATE `crm_app`.`jobs` SET `name` = ?, `start_date` = ?, `end_date` = ? WHERE id = ?";
	
	// Lấy dữ liệu từ database để display lên table
	public List<Job> getDataFromDB() {
		List<Job> jobs = new ArrayList<Job>();
		try (Connection conn = getConnection.getConnectionFormMySQL()) {
			PreparedStatement statement = conn.prepareStatement(SELECT_ALL_FROM);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Job job = new Job();
				job.setId(rs.getInt("id"));
				job.setTenCongViec(rs.getString("name"));
				job.setNgayBatDau(rs.getDate("start_date"));
				job.setNgayKetThuc(rs.getDate("end_date"));
				jobs.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobs;
	}

	//lấy dữ liệu từ DB theo id để hiện ra form 
	public Job getJobFromDbToEdit(int id) {
		Job job = null;
		try (Connection conn = getConnection.getConnectionFormMySQL()) {
			PreparedStatement statement = conn.prepareStatement(SELECT_ALL_WHERE_ID);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				job = new Job();
				job.setId(rs.getInt("id"));
				job.setTenCongViec(rs.getString("name"));
				job.setNgayBatDau(rs.getDate("start_date"));
				job.setNgayKetThuc(rs.getDate("end_date"));

				return job;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int sendDataToDB(Job job) {

		try (Connection conn2 = getConnection.getConnectionFormMySQL()) {
			PreparedStatement statement = conn2.prepareStatement(UPDATE_WHERE_ID);

			statement.setString(1, job.getTenCongViec());
			statement.setDate(2, job.getNgayBatDau());
			statement.setDate(3, job.getNgayKetThuc());
			int rs = statement.executeUpdate();
			return rs;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public int editJob(Job job,int id) {

		try (Connection conn2 = getConnection.getConnectionFormMySQL()) {
			PreparedStatement statement = conn2.prepareStatement(UPDATE_WHERE_ID);
			
			statement.setString(1, job.getTenCongViec());
			statement.setDate(2, job.getNgayBatDau());
			statement.setDate(3, job.getNgayKetThuc());
			statement.setInt(4, id);
			int rs = statement.executeUpdate();
			return rs;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	
	

	public void DeleteByID(int id) {

		try (Connection conn = getConnection.getConnectionFormMySQL()) {
			PreparedStatement statement = conn.prepareStatement(DELECT_WHERE_ID);
			statement.setInt(1, id);
			statement.executeUpdate();
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
