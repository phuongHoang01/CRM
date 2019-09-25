package com.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import com.CRM_Entity.Role;
import com.CRM_Entity.User;
import com.Connection.getConnection;
import com.mysql.cj.Query;

public class RoleDAO {
	private final String DELETE_WHERE_ID = "Delete FROM crm_app.roles WHERE id = ?";
	private final String SELECT_ALL_FROM_ROLES = "SELECT * FROM crm_app.roles";// getRolesFromDB
	private final String iNSERT_INTO_ROLES = "INSERT INTO roles (name, description) VALUES (?, ?)"; // addData
	private final String SELECT_NEEDED_ATTRIBUTE_WHERE_ID = "SELECT * FROM crm_app.roles WHERE id = ?";
	private final String UPDATE_ROLES_WHERE_ID = "UPDATE `crm_app`.`roles` SET `name` = ? , `description` = ? WHERE id = ?";
	//lấy dữ liễu từ DB để display ra table
	public List<Role> getRolesFromDB() {
		List<Role> roleList = new ArrayList<Role>();
		
		
		try (Connection conn2 = getConnection.getConnectionFormMySQL()) {
			PreparedStatement statement2 = conn2.prepareStatement(SELECT_ALL_FROM_ROLES);
			ResultSet rs02 = statement2.executeQuery();
			while (rs02.next()) {
				int id = rs02.getInt("id");
				String name02 = rs02.getString("name");
				String description02 = rs02.getString("description");
				Role role = new Role(id, name02, description02);
				roleList.add(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roleList;
	}

	// Thêm dữ liệu vào database nếu có dữ liệu thì trả về 1 ko có thì -1
	public int addData(Role roleItem) {

		try (Connection conn2 = getConnection.getConnectionFormMySQL()) {

			PreparedStatement statement = conn2.prepareStatement(iNSERT_INTO_ROLES);

			statement.setString(1, roleItem.getName());
			statement.setString(2, roleItem.getDescription());
			int rs = statement.executeUpdate();
			return rs;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;

	}
	
	public Role displayRole(int id) {
		Role role = null;
		try(Connection conn = getConnection.getConnectionFormMySQL()){
			PreparedStatement statement = conn.prepareStatement(SELECT_NEEDED_ATTRIBUTE_WHERE_ID);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				role = new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				role.setDescription(rs.getString("description"));
				return role;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int editRole(Role roleItem,int id) {

		try (Connection conn2 = getConnection.getConnectionFormMySQL()) {

			PreparedStatement statement = conn2.prepareStatement(UPDATE_ROLES_WHERE_ID);
			statement.setString(1, roleItem.getName());
			statement.setString(2, roleItem.getDescription());
			statement.setInt(3, id);
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
			PreparedStatement statement = conn.prepareStatement(DELETE_WHERE_ID);
			statement.setInt(1, id);
			statement.executeUpdate();
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
