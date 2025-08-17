package in.careerit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ProductServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int productId = Integer.parseInt(request.getParameter("productId"));
		String productName = request.getParameter("productName");
		int unitPrice = Integer.parseInt(request.getParameter("unitPrice"));
		int qtyOnHand = Integer.parseInt(request.getParameter("qtyOnHand"));
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		
		Prduct product = new Prduct();
		
		product.setProductId(productId);
		product.setProductName(productName);
		product.setUnitPrice(unitPrice);
		product.setQtyOnHand(qtyOnHand);
		product.setCategory(category);
		product.setDescription(description);
		
		
		request.setAttribute("product", product);
		
		RequestDispatcher rd = request.getRequestDispatcher("productView.jsp");
		rd.forward(request, response);
		
		
		
	}

}
