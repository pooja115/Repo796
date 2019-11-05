package com.lti.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		int eid=Integer.parseInt(request.getParameter("txtEmpid"));
		String ename = request.getParameter("txtEmpname");
	//	Employee e=new Employee();
//		e.setEmpId(Integer.parseInt(request.getParameter("txtEmpid")));
//		e.setEmpName(request.getParameter("txtEmpname"));
//		out.println("ID:" +e.getEmpId()+"Name : "+e.getEmpName());
		
		    out.println("ID:" +eid+"Name : "+ename);
		//    InputStream is =getClass().getClassLoader().getResourceAsStream("config.properties");
		//    Properties prop=new Properties();
		//	prop.load(is);	
//			String driver=(String)prop.get("db.driver");
//			String url=(String)prop.get("db.url");
//			String user=(String)prop.get("db.user");
//			String pass=(String)prop.get("db. pass");
			
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			out.println("connection");
			PreparedStatement ps = conn.prepareStatement("insert into emp_data values(?,?)");
			ps.setInt(1,eid);
			ps.setString(2, ename);
			ps.executeQuery();
//			Statement stmt=conn.createStatement();
//			stmt.executeQuery("insert into emp_data values ("+e.getEmpId()+","+e.getEmpName()+")");
			out.println("Successfully done");
			conn.close();
		    out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
