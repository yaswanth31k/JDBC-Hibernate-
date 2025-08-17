package in.careerit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		ServletContext context = this.getServletContext();
		Persn person =(Persn)context.getAttribute("person");

			if(person != null) {
				out.println("Id: "+person.getId());
				out.println("Name: "+person.getName());
				out.println("Age: <br/>"+person.getAge());
			}else {
				out.println("no such attribute is exist");
			}

		//context.setAttribute("person",person);

		out.println("click <a href=second>here</a> to navigate second. <br/>");
		out.println("click <a href=third>here</a> to navigate third.");


	}

}
