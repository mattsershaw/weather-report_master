package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost/weatherReport";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	public Login selectByLogin(Login loginIns) {
		Login login = null;

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT USER_ID, PASS FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginIns.getUserId());
			pStmt.setString(2, loginIns.getPass());

			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				login = new Login(userId, pass);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		} return login;
	}
	public boolean insertIntoByRegistration(Account accountIns) {

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO ACCOUNT (USER_ID, PASS, TOKEN, NICKNAME, LOCATION) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, accountIns.getUserId());
			pStmt.setString(2, accountIns.getPass());
			pStmt.setString(3, accountIns.getLineToken());
			pStmt.setString(4, accountIns.getNickname());
			pStmt.setString(5, accountIns.getLocation());

			int num = pStmt.executeUpdate();

			if (num != 1) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		} return true;
	}
	public Account selectByManagement(Account accountIns) {
		Account account = null;

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT USER_ID, PASS, TOKEN, NICKNAME, LOCATION FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?"; // LINE_TOKEN = ? AND NICKNAME = ? AND LOCATION = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, accountIns.getUserId());
			pStmt.setString(2, accountIns.getPass());

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()){
			String userId = rs.getString("USER_ID");
			String pass = rs.getString("PASS");
			String lineToken = rs.getString("TOKEN");
			String nickname = rs.getString("NICKNAME");
			String location = rs.getString("LOCATION");
			account = new Account(userId, pass, lineToken, nickname, location);

			}
			rs.close();
			pStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		} return account;
	}
	public boolean updateByManagement(Account accountIns) {
		//Account account = null;

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE ACCOUNT SET USER_ID=?, PASS=?, TOKEN=?, NICKNAME=?, LOCATION=? WHERE USER_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, accountIns.getUserId());
			pStmt.setString(2, accountIns.getPass());
			pStmt.setString(3, accountIns.getLineToken());
			pStmt.setString(4, accountIns.getNickname());
			pStmt.setString(5, accountIns.getLocation());
			pStmt.setString(6, accountIns.getUserId());

			int num = pStmt.executeUpdate();

			if (num >= 1) {
				//account = selectByManagement(accountIns);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		} return true;
	}
	public boolean deleteByManagement(Account accountIns) {

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "DELETE FROM ACCOUNT WHERE USER_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, accountIns.getUserId());

			int num = pStmt.executeUpdate();

			if (num >= 1) {
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		} return true;
	}

}
