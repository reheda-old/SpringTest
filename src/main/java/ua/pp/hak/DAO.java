package ua.pp.hak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// load the Driver Class
		Class.forName("com.mysql.jdbc.Driver");

		// create the connection now
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_test", "root", "123456");
	}

	public static List<Post> getPosts() {
		List<Post> posts = new ArrayList<>();
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT id, txt FROM posts");
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				int id = rs.getInt(1);
				String txt = rs.getString(2);
				posts.add(new Post(id, txt));
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return posts;

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(DAO.getPosts());
	}

	public static void deletePost(int id) {
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("DELETE FROM posts WHERE id=?;");) {

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addPost(String txt) {
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("INSERT INTO posts (txt) VALUES (?);");) {

			ps.setString(1, txt);
			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
