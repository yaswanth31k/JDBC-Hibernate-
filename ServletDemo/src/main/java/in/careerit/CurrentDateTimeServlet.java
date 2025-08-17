package in.careerit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CurrentDateTimeServlet extends HttpServlet {
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			java.util.Date date = new java.util.Date();
			 out.println("current date time is : "+date);
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			PrintWriter out = response.getWriter();
//			java.util.Date date = new java.util.Date();
//			 out.println("current date time is : "+date);
		doGet(request,response);
		}
}
