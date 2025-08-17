<%@ page import="java.util.List " language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<String> gameList = (List)request.getAttribute("gameList");
		out.println("<center>");
		out.println("selected game type is :: "+request.getParameter("gameType")+"<br/>");
		out.println("list of games are :: "+gameList);
		out.println("<center>");

	%>
</body>
</html>