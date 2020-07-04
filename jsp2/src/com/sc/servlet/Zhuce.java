package com.sc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.db.conDB;
@WebServlet("/zhuce")
public class Zhuce extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String uname=req.getParameter("uname");
		String upass=req.getParameter("upass");
		String uageStr=req.getParameter("uage");
		int uage=Integer.parseInt(uageStr);
		System.out.println("用户名："+uname);
		System.out.println("密码："+upass);
		System.out.println("年龄："+uage);
		
		
		
		
		conDB db=new conDB();
		String dir="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/db190506";
		db.getconDb(dir, url, "root", "256246");
//		"insert into users values(null,'tom','123',20)";
		String sql="insert into users values(null,'"+uname+"','"+upass+"',"+uage+")";
		db.exsql(sql);
		db.closes();
		
		resp.setCharacterEncoding("gbk");
		PrintWriter out=resp.getWriter();
		out.println("<center><h1>恭喜注册成功</h1></center>");
		out.close();
		
		
		
	}

}
