package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

import com.CRM_Entity.User;
import com.Connection.getConnection;

public class LoginDAO {
	private String query01 = "SELECT * FROM crm_app.users where email = ? && password = ? ";
	
	private String query02 = "SELECT email,fullname,avatar,role_id,description,users.id,password "
							+"from crm_app.users "
							+"join crm_app.roles "
							+"on crm_app.users.role_id = crm_app.roles.id "
							+"where email = ? && password = ? ";
			
	public User findByEmail(String putEmailHere,String putPasswordHere){
		User user = null;
		try(Connection conn = getConnection.getConnectionFormMySQL()){
			PreparedStatement statement = conn.prepareStatement(query02);
			statement.setString(1, putEmailHere);
			statement.setString(2, putPasswordHere);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setFullName(rs.getString("fullname"));
				user.setAvatar(rs.getString("avatar"));
				user.setDescription(rs.getString("description"));
				user.setRoleID(rs.getInt("role_id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	
}
