package com.sc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class conDB {
	
	   Connection con;
	   Statement stat;
	
	 public Connection  getconDb(String dir,String url,String uname,String upass){
		 try {
			Class.forName(dir);
			con = 
				DriverManager.getConnection
				(url,uname,upass);	
			System.out.println("ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		 return con;
	 }
	
	public void exsql(String sql){
		try {
			stat=con.createStatement();
			stat.execute(sql);
			System.out.println("ok");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void closes(){
		try {
			if(!stat.isClosed()){
				stat.close();
			}
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
