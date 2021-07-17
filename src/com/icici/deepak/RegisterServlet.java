package com.icici.deepak;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
//@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String addr=request.getParameter("addr");
		String mob=request.getParameter("mob");
		String amt=request.getParameter("amt");
		int amount=Integer.valueOf(amt);
		Customer cm=new Customer(name,pass,addr,mob,amount);
		RegisterDao rDao=new RegisterDao();
		String result_acno=rDao.insert(cm);
		StringTokenizer st=new StringTokenizer(result_acno," ");
		String result="";
		int acno=0;
		while(st.hasMoreTokens())
		{
			result=st.nextToken();
			acno=Integer.valueOf(st.nextToken());
		}
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(result.equals("true"))
		{
			out.println("Your account has been successfully created.");
			out.println("Account number is: "+acno);
			
			
			RequestDispatcher rd=request.getRequestDispatcher("NewUser.html");
			rd.include(request, response);
		}
		else if(result.equals("false"))
		{
			out.println("Invalid Inputs!Try Again");
			RequestDispatcher rd=request.getRequestDispatcher("NewUser.html");
			rd.include(request, response);
		}
		out.close();
	}

}
