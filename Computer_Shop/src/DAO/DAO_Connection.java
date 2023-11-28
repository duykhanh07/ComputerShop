package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO_Connection {
	public Connection conn = null;

	public Connection getConnect() {
		return conn;
	}

	public void setConnect(Connection conn) {
		this.conn = conn;
	}
	
	public Connection Connect_mySQL()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycuahang", "root", "");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//Check the status of Connection
	/*
	public static void main(String[] args) {
		DAO_Connection a = new DAO_Connection();
		if(a.Connect_mySQL() != null)
		{
			System.out.println("Successful!!!");
		}
		else
		{
			System.out.println("Failure!!!");
		}
	}
	*/
	
}
