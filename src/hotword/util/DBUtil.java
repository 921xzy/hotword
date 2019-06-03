package hotword.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;

public class DBUtil {
	public  static  Connection getConnection() {
		/*
		 * 锟斤拷锟斤拷锟斤拷锟斤拷
		 */
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/pachong";
		/*
		 * 锟斤拷锟斤拷锟斤拷锟接讹拷锟斤拷
		 */
		Connection connection = null;
		try {
			
			 connection = DriverManager.getConnection(url,user,password);
			 System.out.println("ok");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	/*
	 * 锟截憋拷锟斤拷源锟侥凤拷锟斤拷
	 */
	
	public static void close(Connection connection ) {//锟截憋拷锟斤拷锟接讹拷锟斤拷姆锟斤拷锟�
		try {
			if (connection != null) {
				connection.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement preparedStatement ) {//锟截憋拷锟斤拷浯拷锟斤拷锟斤拷姆锟斤拷锟�
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void close(ResultSet resultSet ) {//锟截闭斤拷锟斤拷锟斤拷姆锟斤拷锟�
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	



}
