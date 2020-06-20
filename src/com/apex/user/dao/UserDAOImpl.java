package com.apex.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.apex.user.vo.User;

@Repository
public class UserDAOImpl implements UserDAO {

	// Getting Connection
	public static Connection getConnection() throws Exception {
		Connection dbConn = null;
		try {
			// step1:
			Class.forName("com.mysql.jdbc.Driver");
			// step2
			String url = "jdbc:mysql://localhost:3306/test";
			// step3
			dbConn = DriverManager.getConnection(url, "root", "root");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return dbConn;
	}

	// Queries

	public void addUser(User user) throws Exception {
		System.out.println("UserDAOImpl:addUser:Start()");
		Connection dbConn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		int rowsInserted = 0;
		try {

			dbConn = getConnection();

			pStmt = dbConn.prepareStatement("insert into  test.usr (firstname,lastname,middlename) values(?,?,?)");
			pStmt.setString(1, user.getFirstName());
			pStmt.setString(2, user.getLastName());
			pStmt.setString(3, user.getMiddleName());
			rowsInserted = pStmt.executeUpdate();
			if (rowsInserted != 1) {
				throw new Exception("Error in inserting the row");

			} else {
				System.out.println(" sucessfully inserted userinfo with given values ");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("UserDAOImpl:addUser:End()");
	}

	public User getUser(int id) {
		Connection dbConn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		User user = null;

		try {
			dbConn = getConnection();
			pStmt = dbConn.prepareStatement("SELECT * FROM usr WHERE userid = ?");
			pStmt.setInt(1, id);
			rs = pStmt.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setMiddleName(rs.getString(4));

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;

	}

	public void updateUser(User user) {
		System.out.println("UserDAOImpl:updateUser:Start()");
		Connection dbConn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		int rowsInserted = 0;
		try {

			dbConn = getConnection();

			pStmt = dbConn
					.prepareStatement("UPDATE usr SET firstname = ?, lastname = ?, middlename = ? WHERE userid = ?");
			pStmt.setString(1, user.getFirstName());
			pStmt.setString(2, user.getLastName());
			pStmt.setString(3, user.getMiddleName());
			pStmt.setInt(4, user.getUserId());

			rowsInserted = pStmt.executeUpdate();
			if (rowsInserted != 1) {
				throw new Exception("Error in updating the row");

			} else {
				System.out.println(" sucessfully updated userId with given values ");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("UserDAOImpl:updateUser:End()");
	}

	public void deleteUser(int id) {
		System.out.println("UserDAOImpl:deleteUser:Start()");
		Connection dbConn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		int rowsDeleted = 0;

		try {

			dbConn = getConnection();

			pStmt = dbConn.prepareStatement("DELETE FROM usr WHERE userid = ?");
			pStmt.setInt(1, id);
			rowsDeleted = pStmt.executeUpdate();

			if (rowsDeleted != 1) {
				throw new Exception("Error in deleting the row");

			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("UserDAOImpl:deleteUser:End()");

	}

	public ArrayList<User> getAllUsers() {
		System.out.println("UserDAOImpl:getAllUsers():Start()");
		Connection dbConn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		User  user;
		ArrayList users=new ArrayList();

		try {

			dbConn = getConnection();

			pStmt = dbConn.prepareStatement("SELECT * FROM usr");

			rs = pStmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rs.next()) {		
				user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				users.add(user);
				System.out.println(" firstName from arraylist "+user.getFirstName());
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("UserDAOImpl:getAllUsers:End()");
		return users;
	}
}