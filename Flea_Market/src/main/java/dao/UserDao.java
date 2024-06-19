package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.User;

public class UserDao extends DaoAbstract {
	private static final String USER_TABLE = "userinfo";
	
	/**
	 * 要求されたユーザインスタンスを返す
	 * 対象のユーザ情報が存在しない場合、User.id = -1のインスタンスを返す
	 */
	public User selectByUserIdAndPassword(int userId, String password) {
		String sql = """
			SELECT * FROM %s WHERE user_id=? AND password=?
			""".formatted(USER_TABLE);
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setInt(1, userId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			User user = new User();
			if (rs.next()) {
				registerUserData(user, rs);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
		return null;
	}
	
	/**  全ユーザ情報を表示 */
	public ArrayList<User> selectAll() {
		String sql = """
			SELECT * FROM %s
			""".formatted(USER_TABLE);
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ResultSet rs = ps.executeQuery();
			ArrayList<User> userList = new ArrayList<>();
			while (rs.next()) {
				User user = new User();
				registerUserData(user, rs);
				userList.add(user);
			}
			return userList;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	public int insert(User user) {
		String sql = """
			INSERT INTO %s(name, password, nickname, address, email, authority)
			VALUES(?, ?, ?, ?, ?, ?)
			""".formatted(USER_TABLE);
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getNickname());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getAuthority());
			int ret = ps.executeUpdate();
			return ret;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	private User registerUserData(User user, ResultSet rs) throws SQLException {
		user.setUserId(rs.getInt("user_id"));
		user.setName(rs.getString("name"));
		user.setNickname(rs.getString("nickname"));
		user.setAddress(rs.getString("address"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setAuthority(rs.getInt("authority"));
		return user;
	}
}
