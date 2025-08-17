<%@ page import = "in.careerit.Prduct" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="product" class="in.careerit.Prduct" scope="request">
		 <jsp:setProperty property="productId" name="product" value="1000"/> 
		  <jsp:setProperty property="productName" name="product" value="disk"/> 
		  <jsp:setProperty property="unitPrice" name="product" value="100"/> 
		  <jsp:setProperty property="qtyOnHand" name="product" value="20"/> 
		  <jsp:setProperty property="category" name="product" value="electrinic"/> 
		  <jsp:setProperty property="description" name="product" value="storage"/> 
		 
	</jsp:useBean>
			product id : <jsp:getProperty property="productId" name="product"/> <br/>
			product name :  <jsp:getProperty property="productName" name="product"/> <br/>
			unit price :  <jsp:getProperty property="unitPrice" name="product"/> <br/>
			qty on hand :  <jsp:getProperty property="qtyOnHand" name="product"/> <br/>
			category :  <jsp:getProperty property="category" name="product"/> <br/>
			Description :  <jsp:getProperty property="description" name="product"/> <br/>



<%-- 	<%
		 Prduct product = (Prduct)request.getAttribute("product");
		
	%>
			product id : <%=product.getProductId()%> <br/>
			product name : <%=product.getProductName() %> <br/>
			unit price : <%=product.getUnitPrice() %> <br/>
			qty on hand : <%=product.getQtyOnHand() %><br/>
			category : <%= product.getCategoty() %><br/>
			Description : <%=product.getDescription() %> <br/>
	 
 --%>
 </body>
</html>