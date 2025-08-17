
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>time and date</title>
</head>
<body>
	welcome to first jsp page <br/>
	this is my first test page <br/>
	
	<!-- Declaration -->
	<%!
		
		
		
	 	int n1 =10 ;
		int n2 =20;
		
		int sum(){
			return n1+n2;
		}
		
		int sum(int n , int m ){
			return n + m ;
		}
		
	%>
	<!-- Scriptlet -->
	<% 
	 	out.println("current date time :: "+ new java.util.Date() + "<br/>");
		int n1 = 1;
		int n2 = 2 ;
		int sum = n1+ n2;
		
		
	%>
	
	<!-- expression -->
	<%= "sum = "+sum%> <br/>
	<%= "sum = "+sum(100,100)%> <br/>
	<%= "sum = "+sum()%> <br/>
	
	
</body>
</html>