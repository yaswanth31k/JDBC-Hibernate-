<%@ page import= "in.careerit.Prduct" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%-- first approch
	<%
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
		
		
		
		/*out.println("product id : "+productId+"<br/>");
		out.println("product name : "+productName+"<br/>");
		out.println("unit price : "+unitPrice+"<br/>");
		out.println("qty on hand : "+qtyOnHand+"<br/>");
		out.println("category : "+category+"<br/>");
		out.println("Description : "+description+"<br/>");*/
	%>
		product id : <%=productId%> <br/>
		product name : <%= productName %> <br/>
		unit price : <%=unitPrice %> <br/>
		qty on hand : <%=qtyOnHand %><br/>
		category : <%= category %><br/>
		Description : <%=description %> <br/>
	 --%>
	 
<%-- 	 Approach : 2
	 <jsp:useBean id="product" class="in.careerit.Prduct" scope="request">
		 <jsp:setProperty property="productId" name="product" value="<%=Integer.parseInt(request.getParameter(\"productId\"))%>"/> 
		  <jsp:setProperty property="productName" name="product" value="<%=request.getParameter(\"productName\")%>"/> 
		  <jsp:setProperty property="unitPrice" name="product" value="<%=Integer.parseInt(request.getParameter(\"unitPrice\"))%>"/> 
		  <jsp:setProperty property="qtyOnHand" name="product" value="<%=Integer.parseInt(request.getParameter(\"qtyOnHand\"))%>"/> 
		  <jsp:setProperty property="category" name="product" value="<%=request.getParameter(\"category\")%>"/> 
		  <jsp:setProperty property="description" name="product" value="<%=request.getParameter(\"description\")%>"/> 
		 
	</jsp:useBean>
	
	<jsp:forward page="productView.jsp"></jsp:forward> 
 --%>
 
 <%-- approach : 3
 <jsp:useBean id="product" class="in.careerit.Prduct" scope="request">
		 <jsp:setProperty property="productId" name="product" param="productId"/> 
		  <jsp:setProperty property="productName" name="product" param="productName"/> 
		  <jsp:setProperty property="unitPrice" name="product" param="unitPrice"/> 
		  <jsp:setProperty property="qtyOnHand" name="product" param="qtyOnHand"/> 
		  <jsp:setProperty property="category" name="product" param="category"/> 
		  <jsp:setProperty property="description" name="product" param="description"/> 
		 
	</jsp:useBean>
	
	<jsp:forward page="productView.jsp"></jsp:forward> 
  --%>
  
  
 	<%-- 
 	approach : 4
 	<jsp:useBean id="product" class="in.careerit.Prduct" scope="request">
		 <jsp:setProperty property="productId" name="product" /> 
		  <jsp:setProperty property="productName" name="product"/> 
		  <jsp:setProperty property="unitPrice" name="product" /> 
		  <jsp:setProperty property="qtyOnHand" name="product" /> 
		  <jsp:setProperty property="category" name="product" /> 
		  <jsp:setProperty property="description" name="product" /> 
		 
	</jsp:useBean>
	
	<jsp:forward page="productView.jsp"></jsp:forward> 
  --%>
  
   <!-- aproach:5 -->
 	<jsp:useBean id="product" class="in.careerit.Prduct" scope="request">
		 <jsp:setProperty property="*" name="product" /> 
		 
		 
	</jsp:useBean>
	
	<jsp:forward page="productView.jsp"></jsp:forward> 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 	
</body>
</html>