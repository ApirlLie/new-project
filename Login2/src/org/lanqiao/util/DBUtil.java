package org.lanqiao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// 省略import
public class DBUtil
{
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static Context ctx = null; 
	private static DataSource ds = null ; 
	static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	static final String USER_NAMR = "scott";
	static final String PASSWORD = "Scott123456";
	//查询语句
	public static ResultSet executeQuery(String sql, Object[] os){
		ResultSet rs = null;
		try {
			pstmt = getPstmt(sql, os);
			
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("建立ResultSet成功");
		return rs;
	};
	 //通用的获取connection方法
	public static Connection getConnection(){
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER_NAMR, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//通用的获取preparedStatem
	public static  PreparedStatement getPstmt(String sql, Object[] os){
		try {
			pstmt = getConnection().prepareStatement(sql);
			if (os != null) {
				for (int i = 0; i < os.length; i++) {
					pstmt.setObject(i + 1, os[i]);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}
	// 通用的，关闭访问数据库相关对象的方法(注意PreparedStatement继承自Statement)
		public static void closeAll(ResultSet rs, PreparedStatement pstmt , Connection conn) {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

//	// 查询数据总数
	public static int getTotalCount(String sql)
	{	
		int count = -1;
		ResultSet rs = null;
		try
		{
			pstmt = getPstmt(sql,null);
			rs = pstmt.executeQuery();
			if (rs.next())
			{
				count = rs.getInt(1);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, conn);
		}
		return count;
	}
}
