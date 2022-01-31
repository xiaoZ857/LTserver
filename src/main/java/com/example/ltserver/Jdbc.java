package com.example.ltserver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Jdbc {
	public static Connection connect2DB() throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";	//driver name
		String url = "jdbc:mysql://18.134.22.186:3306/test_db?serverTimezone=GMT&useSSL=false";	//将要访问的数据库名称testone
		String user = "root";	//mysql user name
		String password = "yourpassword";
		Class.forName(driver);	//load driver
		Connection conn = DriverManager.getConnection(url, user, password);	
		if(!conn.isClosed())
			System.out.println("Succeed!"); 
		return conn;
	}
	
	
	public static void main(String[] args) {
	try {
		
		Connection conn = connect2DB();	
		Statement state = conn.createStatement();	//create statement object to execute MySQL//create statement object to execute MySQL 
		String name = "Chenxiao Guo";
		String sql = "select * from test_table where Name = '"+name+"'";	//query
		ResultSet rst = state.executeQuery(sql);	//to store the result
		while(rst.next()) {
			System.out.println(rst.getString("email"));	
		}/*
		Add new to database
		String name1 = "Haoran Chen";
		String email1 = "2510947C@student.gla.ac.uk";
		String BCADD1 = "asdfghhjjjjk";
		String sql = "INSERT INTO test_table (Name,email,BCADD) VALUES('"+name1+"','"+email1+"','"+BCADD1+"')";
		conn.setAutoCommit(false);
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.executeUpdate();
		conn.commit();*/
		conn.close();
		state.close();
		System.out.println("succeed!");
		}catch(Exception e) {
			System.out.println("defeat!");
			System.out.println(e);
		}
	}
}
