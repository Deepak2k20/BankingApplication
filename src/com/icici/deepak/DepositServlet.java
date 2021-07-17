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
 * Servlet implementation class DepositServlet
 */
//@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositServlet() {
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
		int acno=Integer.valueOf(request.getParameter("acno"));
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		int d_amt=Integer.valueOf(request.getParameter("damt"));
		Deposit d=new Deposit(acno,uname,pass,d_amt);
		DepositDao dDao=new DepositDao();
		String result_amt=dDao.deposit(d);
		StringTokenizer st=new StringTokenizer(result_amt," ");
		String result="";
		int amt=0;
		while(st.hasMoreTokens())
		{
			result=st.nextToken();
			amt=Integer.valueOf(st.nextToken());
		}
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(result.equals("true"))
		{
			out.println("Your amount is deposited successfully into your account.");
			out.println("Account balance is: "+amt);
			
			RequestDispatcher rd=request.getRequestDispatcher("deposit.html");
			rd.include(request, response);
		}
		else if(result.equals("false"))
		{
			out.println("Invalid Inputs!Try Again");
			RequestDispatcher rd=request.getRequestDispatcher("deposit.html");
			rd.include(request, response);
		}
	}

}
