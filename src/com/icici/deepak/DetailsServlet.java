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
 * Servlet implementation class DetailsServlet
 */
//@WebServlet("/detailsServlet")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		Details d=new Details(acno,uname,pass);
		DetailsDao dDao=new DetailsDao();
		String result=dDao.details(d);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(result.equals("false"))
		{
			out.println("Invalid info!Please enter valid details.");
			RequestDispatcher rd=request.getRequestDispatcher("details.html");
			rd.include(request, response);
		}
		else 
		{
			
		
		StringTokenizer st=new StringTokenizer(result,",");
		String acno_="";
		String name="";
		String pass_="";
		String address="";
		String mob="";
		String amt="";
		String created_at="";
		while(st.hasMoreTokens())
		{
			acno_=st.nextToken();
			name=st.nextToken();
			pass_=st.nextToken();
			address=st.nextToken();
			mob=st.nextToken();
			amt=st.nextToken();
			created_at=st.nextToken();
		}
			out.println("<html>");
			out.println("<head>");
			out.println("Account details are:");
			out.println("</head");
			out.println("<body>");
			out.println("<h2>"+acno_+"</h2>");
			out.println("<h2>"+name+"</h2>");
			out.println("<h2>"+pass_+"</h2>");
			out.println("<h2>"+address+"</h2>");
			out.println("<h2>"+mob+"</h2>");
			out.println("<h2>"+amt+"</h2>");
			out.println("<h2>"+created_at+"</h2>");
			out.println("<br><br>");
			out.println("<a href=\"home.html\"><button type=\"submit\" class=\"gobackbtn btn\">Home</button></a>");
			out.println("</body>");
			out.println("</html");
			
		}
	
	}

}
