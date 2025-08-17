package in.carrerit;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class PersonalDetailsServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		//read the form data
		String email = request.getParameter("emailId");
		String mobile = request.getParameter("mobileNo");
		String city = request.getParameter("city");
		
		//create a cookie 
		String name = URLEncoder.encode(request.getParameter("name"), "UTF-8");
		
		Cookie cookie = new Cookie("name",name);
		Cookie cookie1 = new Cookie("emailId",email);
		Cookie cookie2 = new Cookie("mobileNo",mobile);
		Cookie cookie3 = new Cookie("city",city);

		// add the above cookie to the response
		
		response.addCookie(cookie);
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		
		
		
		response.sendRedirect("dashboard");

		
	}

}
