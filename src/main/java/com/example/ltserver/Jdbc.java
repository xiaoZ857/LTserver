package com.example.ltserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {
//	public static Connection connect2DB() throws Exception {
//		String driver = "com.mysql.cj.jdbc.Driver";	//driver name
//		String url = "jdbc:mysql://localhost:3306/TEST?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";	//将要访问的数据库名称testone
//		String user = "root";	//mysql user name
//		String password = "123456";
//		Class.forName(driver);	//load driver
//		Connection conn = DriverManager.getConnection(url, user, password);
//		if(!conn.isClosed())
//			System.out.println("Connection Succeed!");
//		return conn;
//	}
	
	
//	public static void main(String[] args) {
//	try {
//
//		Connection conn = connect2DB();
//		Statement state = conn.createStatement();	//create statement object to execute MySQL//create statement object to execute MySQL
//		String name = "Zhou zihan";
//		String sql = "select * from students where Name = '"+name+"'";	//query
//		ResultSet rst = state.executeQuery(sql);	//to store the result
//		while(rst.next()) {
//			System.out.println(rst.getString("email"));
//		}/*
//		Add new to database
//		String name1 = "Haoran Chen";
//		String email1 = "2510947C@student.gla.ac.uk";
//		String BCADD1 = "asdfghhjjjjk";
//		String sql = "INSERT INTO test_table (Name,email,BCADD) VALUES('"+name1+"','"+email1+"','"+BCADD1+"')";
//		conn.setAutoCommit(false);
//		PreparedStatement preparedStatement = conn.prepareStatement(sql);
//		preparedStatement.executeUpdate();
//		conn.commit();*/
//		conn.close();
//		state.close();
//		System.out.println("search succeed!");
//		}catch(Exception e) {
//			System.out.println("search defeat!");
//			System.out.println(e);
//		}
//	}

//	public String checklogin(String email){
//		String psw = null;
//		Connection con =null;
//		PreparedStatement pstmt =null;
//		ResultSet rs = null;
//		try {
//			String driver ="com.mysql.cj.jdbc.Driver";
//			String url ="jdbc:mysql://localhost:3306/TEST?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
//			String user ="root";
//			String password ="123456";//改为自己的用户名密码和数据库名
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, user, password);
//			String sql = "select * from students where email=?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, email);
//			rs = pstmt.executeQuery();
//			if(rs==null){
//				return null;
//			}
//			if(rs.next()) psw = rs.getString("Password");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(pstmt!=null)pstmt.close();
//				if(con!=null)con.close();
//			}
//			catch (SQLException e) {
//			}
//		}
//		return psw;
//	}
//
//	public void addStudent(String Name,String email,String Password){
//		Connection con =null;
//		PreparedStatement pstmt =null;
//		try {
//			String driver ="com.mysql.cj.jdbc.Driver";
//			String url ="jdbc:mysql://localhost:3306/TEST?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
//			String user ="root";
//			String password ="123456";//改为自己的用户名密码和数据库名
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, user, password);
//			String sql = "INSERT INTO students VALUES(?,?,?)";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, Name);
//			pstmt.setString(2, email);
//			pstmt.setString(3, Password);
//			pstmt.executeUpdate();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(pstmt!=null)pstmt.close();
//				if(con!=null)con.close();
//			}
//			catch (SQLException e) {
//			}
//		}
//	}
//	public String getname(String email){
//
//
//	}
Connection conn = null;

		         public Connection getConnection() throws ClassNotFoundException, SQLException {
		             String driver="com.mysql.cj.jdbc.Driver";
		             String url="jdbc:mysql://localhost:3306/TEST?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";    //数据库地址
		             String user="root";
		             String password="123456";

		             Class.forName(driver);
		             try {
			                 conn = DriverManager.getConnection(url,user,password);
			             } catch (SQLException e) {
			                 e.printStackTrace();
			             }

					 if(!conn.isClosed())
						System.out.println("Connection Succeed!");

		             return conn;
		         }








}
