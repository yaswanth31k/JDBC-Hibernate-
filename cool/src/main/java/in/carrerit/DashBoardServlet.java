package in.carrerit;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DashBoardServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			Cookie[] cookie = request.getCookies();
			if(cookie == null ) {
				out.println("<h4 align = center> not yet logged in , click <a href='PersonalDetails.html'> here </a> to login <h4>");
			}else {
			    String name	= URLDecoder.decode(cookie[0].getValue(), "UTF-8");
				String email = cookie[1].getValue();
				String mobile = cookie[2].getValue();
				String city = cookie[3].getValue();
				

				out.println("<table align='center' border='3'>");
				out.println("<tr>");
				out.println("<th>name</th>");
				out.println("<td>"+name+"</td>");
				out.println("</tr>");
				
				
				out.println("<tr>");
				out.println("<th>email id</th>");
				out.println("<td>"+email+"</td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<th>mobile no</th>");
				out.println("<td>"+mobile+"</td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<th>city</th>");
				out.println("<td>"+city+"</td>");
				out.println("</tr>");

				
			}
	}

}
