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
 * Servlet implementation class WithdrawServlet
 */
//@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawServlet() {
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
		int w_amt=Integer.valueOf(request.getParameter("wamt"));
		Withdraw w=new Withdraw(acno,uname,pass,w_amt);
		WithdrawDao wDao=new WithdrawDao();
		String result_amt=wDao.withdraw(w);
		StringTokenizer st=new StringTokenizer(result_amt," ");
		String result="";
		int r_amt=0;
		while(st.hasMoreTokens())
		{
			result=st.nextToken();
			r_amt=Integer.valueOf(st.nextToken());
		}
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(result.equals("true"))
		{
			out.println("Your amount is withdrawn successfully from your account.");
			out.println("Remaining balance is: "+r_amt);
			RequestDispatcher rd=request.getRequestDispatcher("withdraw.html");
			rd.include(request, response);
		}
		else if(result.equals("not"))
		{
			out.println("Insufficient balance into your account.Try to withdraw less amount.");
			RequestDispatcher rd=request.getRequestDispatcher("withdraw.html");
			rd.include(request, response);
		}
		else
		{
			out.println("Invalid Details!Try Again.");
			RequestDispatcher rd=request.getRequestDispatcher("withdraw.html");
			rd.include(request, response);
		}

	}

}
