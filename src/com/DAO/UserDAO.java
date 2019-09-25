package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.CRM_Entity.Role;
import com.CRM_Entity.User;
import com.Connection.getConnection;
import com.sun.crypto.provider.RSACipher;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Single;



public class UserDAO {
	private final String SELECT_NEEDED_ATTRIBUTE = "SELECT email,fullname,avatar,role_id,description,users.id "
			+ "FROM crm_app.users join crm_app.roles "
			+ "ON crm_app.users.role_id = crm_app.roles.id";
	
	private final String INSERT_INTO_USERS = "INSERT INTO `crm_app`.`users` (`email`, `password`, `fullname`, `avatar`, `role_id`) VALUES (?, ?, ?, ?, ?)";
	
	private final String DELETE_WHERE_ID = "Delete FROM crm_app.users WHERE id = ?";
	
	private final String UPDATE_WHERE_ID = "UPDATE `crm_app`.`users` SET `email` = ?,fullname = ?,avatar = ?,role_id = ? WHERE id = ?";
	
	private final String SELECT_NEEDED_ATTRIBUTE_WHERE_ID = "SELECT email,fullname,avatar,role_id,description,users.id,password "
						+ "FROM crm_app.users join crm_app.roles "
						+ " ON crm_app.users.role_id = crm_app.roles.id "
						+ " where users.id = ?";
	
	
	public List<User> getDataFormDB(){
		List<User> users = new ArrayList<User>();
		
		try(Connection conn = getConnection.getConnectionFormMySQL()){
			PreparedStatement statement = conn.prepareStatement(SELECT_NEEDED_ATTRIBUTE);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setFullName(rs.getString("fullname"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleID(rs.getInt("role_id"));
				user.setDescription(rs.getString("description"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	//Thêm người dùng vào database
	public int addUser(User user) {
		try(Connection conn = getConnection.getConnectionFormMySQL()) {
			PreparedStatement statement = conn.prepareStatement(INSERT_INTO_USERS);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullName());
			statement.setString(4, user.getAvatar());
			statement.setInt(5, user.getRoleID());
			int rs = statement.executeUpdate();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	
	public int editUser(User user,int id) {
		try(Connection conn = getConnection.getConnectionFormMySQL()) {
			PreparedStatement statement = conn.prepareStatement(UPDATE_WHERE_ID);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getFullName());
			statement.setString(3, user.getAvatar());
			statement.setInt(4, user.getRoleID());
			statement.setInt(5, id);
			int rs = statement.executeUpdate();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	
	public User displayUser(int id) {
			User user = null;
			try(Connection conn = getConnection.getConnectionFormMySQL()){
				PreparedStatement statement = conn.prepareStatement(SELECT_NEEDED_ATTRIBUTE_WHERE_ID);
				statement.setInt(1, id);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					user = new User();
					user.setId(rs.getInt("id"));
					user.setEmail(rs.getString("email"));
					user.setFullName(rs.getString("fullname"));
					user.setAvatar(rs.getString("avatar"));
					user.setRoleID(rs.getInt("role_id"));
					user.setDescription(rs.getString("description"));
					return user;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	
	
	public void DeleteByID(int id) {
		
		try(Connection conn = getConnection.getConnectionFormMySQL()) {
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
