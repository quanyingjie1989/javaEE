package org.asjy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

	 public static final String DRIVER = "com.mysql.jdbc.Driver";
	 public static final String URL = "jdbc:mysql://localhost:3306/xx";
	 public static final String USER = "root";
	 public static final String PASSWORD = "root";
	
	 /**
	  * ��������
	  */
	  public static Connection getMySelfConnection() {
		  Connection conn = null;
		  try {
			  Class.forName(DRIVER);
			  conn = DriverManager.getConnection(URL,USER,PASSWORD);
		  } catch (Exception e) {
			System.out.println("����ʧ��");
			e.printStackTrace();
		  }
		  return conn;
	  }
	  /**
	   * �ر���Դ�ķ���
	   */
	  public static void myselfClose(Connection conn,PreparedStatement pstm,ResultSet rs) {
		  //�ر�����  �Ự  �����
		 if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		 if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	  }
}
